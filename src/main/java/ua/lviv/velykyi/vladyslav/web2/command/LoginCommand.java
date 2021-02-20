package ua.lviv.velykyi.vladyslav.web2.command;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.RoleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.lviv.velykyi.vladyslav.Path.PAGE__HOME;

public class LoginCommand extends Command {

    private static final Logger log = Logger.getLogger(LoginCommand.class);


    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        RoleService roleService = new RoleServiceImpl();

//
//        log.debug("Command starts");
//
//        HttpSession session = request.getSession();
//
//        String login = request.getParameter("login");
//        log.trace("Request parameter: loging --> " + login);
//
//        String password = request.getParameter("password");
//
//        String errorMessage;
//        String forward = Path.PAGE__ERROR_PAGE;
//
//
//        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
//            errorMessage = "Login/password cannot be empty";
//            request.setAttribute("errorMessage", errorMessage);
//            log.error("errorMessage --> " + errorMessage);
//            return forward;
//        }
//
//        Employee employee = employeeService.findByLogim(login);
//        log.trace("Found in DB: user --> " + employee);
//        if (employee == null || !password.equals(employee.getPass())) {
//            errorMessage = "Cannot find user with such login/password";
//            request.setAttribute("errorMessage", errorMessage);
//            log.error("errorMessage --> " + errorMessage);
//            return forward;
//        } else {
//            int roleId = employeeService.findByLogim(login).getRoleId();
//            Role employeeRole = roleService.findById(roleId);
//            log.trace("userRole --> " + employeeRole);
//
//            if (employeeRole.getName().equals("admin")) {
//                forward = Path.COMMAND__LIST_ORDERS;
//            } else {
//                forward = Path.COMMAND__LIST_MENU;
//            }
//
//            session.setAttribute("user", employee);
//            log.trace("Set the session attribute: user --> " + employee);
//
//            session.setAttribute("userRole", employeeRole);
//            log.trace("Set the session attribute: userRole --> " + employeeRole);
//
//            log.info("User " + employee+ " logged as " + employeeRole.toString().toLowerCase());
//
//        }
//        log.debug("Command finished");
//        return forward;


        return PAGE__HOME;
    }
}
