package ua.lviv.velykyi.vladyslav.db.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.dao.impl.EmployeeDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.service.EmployeeService;

import java.util.List;

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

    @Override
    public void update(Employee employee) {
        dao.update(employee);
    }

    @Override
    public void insert(Employee employee) {
        dao.insert(employee);
    }

    @Override
    public void delete(String login) {
       Employee neededCategory = dao.findAll()
                .stream()
                .filter(category -> category.getName().equals(login))
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
