
import ua.lviv.velykyi.vladyslav.db.dao.impl.CategoryDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;
import ua.lviv.velykyi.vladyslav.db.service.impl.CategoryServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.RoleServiceImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
//        EmployeeDAO dd = new EmployeeDAO();
//        Employee employee = new Employee();
//        employee.setId(2L);
//        employee.setName("g");
//        employee.setLogin("g");
//        employee.setPass("g");
//        employee.setRoleId(1);
//        employee.setSurname("g");
//        System.out.println(dd.findAll());
//        dd.update(employee);
//        System.out.println(dd.findAll());
//
//        dd.delete(employee);
//        System.out.println(dd.findAll());
//        dd.insert(employee);
//        System.out.println(dd.findAll());

//        CategoryServiceImpl cs = new CategoryServiceImpl();
//        Category category = new Category();
//        category.setName("el");
//        cs.insert(category);
//        System.out.println(cs.findAll());
//        category.setName("2");
//        cs.delete(category.getName());
//        System.out.println(cs.findAll());
        RoleService roleService = new RoleServiceImpl();
        System.out.println(roleService.findAll());
    }
}
