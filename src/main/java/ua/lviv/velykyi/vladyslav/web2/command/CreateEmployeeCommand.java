package ua.lviv.velykyi.vladyslav.web2.command;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateEmployeeCommand extends Command{
    private static final Logger log = Logger.getLogger(CreateEmployeeCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        Employee employee = new Employee();
        RoleService roleService = new RoleServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();

        employee.setName(request.getParameter("name"));
        log.debug(request.getParameter("name"));
        employee.setSurname(request.getParameter("surname"));
        log.debug(request.getParameter("surname"));

        employee.setLogin(request.getParameter("login"));
        log.debug(request.getParameter("login"));

        employee.setPass(request.getParameter("password"));
        log.debug(request.getParameter("password"));
        employee.setRoleId(roleService.findByName(request.getParameter("role")).getId());
        log.debug(request.getParameter("role"));
       // employee.setLocaleId();
        employeeService.insert(employee);

        return Path.PAGE__HOME_ADMIN;
    }
}
