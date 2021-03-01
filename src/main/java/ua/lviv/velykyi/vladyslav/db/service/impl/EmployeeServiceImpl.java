package ua.lviv.velykyi.vladyslav.db.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.bean.EmployeeBean;
import ua.lviv.velykyi.vladyslav.db.dao.impl.EmployeeDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.entity.Entity;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = Logger.getLogger(EmployeeServiceImpl.class);
    private EmployeeDAO dao;

    public EmployeeServiceImpl() {
        dao = new EmployeeDAO();
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Employee findByLastName(String surname) {
        return dao.findAll()
                .stream()
                .filter(employee -> employee.getSurname().equals(surname))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee findByLogim(String login) {
        return dao.findAll()
                .stream()
                .filter(employee -> employee.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee findByRole(Long roleId) {
        return dao.findAll()
                .stream()
                .filter(employee -> employee.getRoleId() == roleId)
                .findFirst()
                .orElse(null);
    }

    public List<EmployeeBean> getBeanList() {
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Employee> employees = dao.findAll();
        List<EmployeeBean> employeeBeans = new ArrayList<>();

        for (Employee e : employees) {
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setId(e.getId());
            employeeBean.setName(e.getName());
            employeeBean.setSurname(e.getSurname());
            employeeBean.setLogin(e.getLogin());
            employeeBean.setPassword(e.getPass());
            employeeBean.setRole(roleService.findById(e.getRoleId()).getName());
            employeeBean.setLocale("test");
            employeeBeans.add(employeeBean);
        }
        return employeeBeans;
    }

    @Override
    public void update(Employee employee) {
        dao.update(employee);
    }

    @Override
    public void insert(Employee employee) {
        dao.insert(employee);
    }

    @Override
    public void delete(long id) {
        Employee neededCategory = dao.findAll()
                .stream()
                .filter(category -> category.getId()==id)
                .findFirst()
                .orElse(null);

        if (neededCategory == null) {
            log.info("No such category");
        } else {
            dao.delete(neededCategory);
            log.info("Category successfully has been deleted");
        }
    }


}
