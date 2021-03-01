package ua.lviv.velykyi.vladyslav.web2.command.employees;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;
import ua.lviv.velykyi.vladyslav.web2.command.employees.ShowEmployeesCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteEmployeeCommand extends Command {
    private static final Logger log = Logger.getLogger(ShowEmployeesCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = employeeService.findAll();
        log.info(request.getParameter("id"));
        employeeService.delete(Long.valueOf(request.getParameter("id")));
        return Path.PAGE__HOME_ADMIN;
    }
}
