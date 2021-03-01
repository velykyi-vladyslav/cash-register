package ua.lviv.velykyi.vladyslav.web2.command.employees;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.bean.EmployeeBean;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ShowEmployeesCommand extends Command {
    private final static String emptyString = "";

    private static final Logger log = Logger.getLogger(ShowEmployeesCommand.class);

    private static Comparator<EmployeeBean> compareById = new CompareById();



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Commands starts");
        List<EmployeeBean> employeeBeans = new EmployeeServiceImpl().getBeanList();
        log.debug("Generated beans -> " + employeeBeans);


        request.setAttribute("employeesBeanList", employeeBeans);

        log.debug("Commands finished");
        boolean s = true;
        try {
            log.debug("attribute  -> " + request.getAttribute("showEmployees"));
            s = !Boolean.getBoolean(request.getAttribute("showEmployees").toString());
            log.debug(s);
        } catch (NullPointerException e) {
            log.error(e.getMessage());
        }


        request.setAttribute("showEmployees", s);
        log.debug("attribute boolean -> " + s);
        log.debug("attribute  -> " + request.getAttribute("showEmployees"));
        return Path.PAGE__HOME_ADMIN;
    }

    private static class CompareById implements Comparator<EmployeeBean> {
        public int compare(EmployeeBean bean1, EmployeeBean bean2) {
            if (bean1.getId() > bean2.getId())
                return 1;
            else return -1;
        }
    }
}
