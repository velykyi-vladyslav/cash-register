
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.dao.impl.CategoryDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.entity.Role;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;
import ua.lviv.velykyi.vladyslav.db.service.impl.CategoryServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.EmployeeServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.RoleServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Employee employee = new Employee();
        RoleService roleService = new RoleServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();

        employee.setName("hello");
        employee.setSurname("hello");
        employee.setLogin("hello");
        employee.setPass("password");
        employee.setRoleId(1);
        // employee.setLocaleId();
        employeeService.insert(employee);

    }
}
