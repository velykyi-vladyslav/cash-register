package ua.lviv.velykyi.vladyslav.web2.command.login;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.entity.Role;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.RoleServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.lviv.velykyi.vladyslav.Path.*;
import static ua.lviv.velykyi.vladyslav.db.constant.RoleConstant.*;

public class LoginCommand extends Command {

    private static final Logger log = Logger.getLogger(LoginCommand.class);


    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        RoleService roleService = new RoleServiceImpl();


        log.debug("Command starts");

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        log.trace("Request parameter: loging --> " + login);

        String password = request.getParameter("password");
        log.debug("password -> " + password);
        String errorMessage;
        String forward = Path.PAGE__ERROR_PAGE;


        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            errorMessage = "Login/password cannot be empty";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }

        Employee employee = employeeService.findByLogim(login);
        log.info("Found in DB: employee --> " + employee);
        log.debug(employee.getPass());
        if (employee == null || !password.equals(employee.getPass())) {
            errorMessage = "Cannot find user with such login/password";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        } else {
            long roleId = employeeService.findByLogim(login).getRoleId();
            log.debug("Role id -> " + roleId);
            Role employeeRole = roleService.findById(roleId);
            log.trace("userRole --> " + employeeRole);

            if (ADMIN.equals(employeeRole.getName())) {
                forward = PAGE__HOME_ADMIN;
            }

            if (CASHIER.equals(employeeRole.getName())) {
                forward = PAGE__HOME_CASHIER;
            }
            if (COMMODITY_EXPERT.equals(employeeRole.getName())){
                forward = PAGE__HOME_COMMODITY_EXPERT;
            }


            session.setAttribute("employee", employee);
            session.setAttribute("employeeLogin", employee.getLogin());
            log.trace("Set the session attribute: user --> " + employee.getLogin());

            session.setAttribute("employeeRole", employeeRole.getName());
            log.trace("Set the session attribute: userRole --> " + employeeRole.getName());

            log.info("Employee " + employee + " logged as " + employeeRole.toString().toLowerCase());
        }
        log.debug("Command finished");
        return forward;

    }
}
