
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.bean.EmployeeBean;
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
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws SQLException {
        boolean b = false;
        Object o = b;
        System.out.println(Boolean.FALSE.equals(o));

    }
}
