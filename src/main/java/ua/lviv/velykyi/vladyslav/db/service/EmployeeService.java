package ua.lviv.velykyi.vladyslav.db.service;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByLastName(String surname);
    Employee findByLogim(String login);
    Employee findByRole(Long roleId);
    void update(Employee employee);
    void insert(Employee employee);
    void delete(String login);
}
