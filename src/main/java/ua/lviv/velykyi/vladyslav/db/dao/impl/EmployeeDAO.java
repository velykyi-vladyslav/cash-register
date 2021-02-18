package ua.lviv.velykyi.vladyslav.db.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.Fields;
import ua.lviv.velykyi.vladyslav.db.dao.GeneralDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.service.impl.DefaultPreparedStatementService;

import java.sql.*;

public  class EmployeeDAO extends GeneralDAO<Employee>   {
    private static final Logger log = Logger.getLogger(GeneralDAO.class);
    private static final String TABLE_NAME = "employees";

    public EmployeeDAO() {
        super();
        setTable(TABLE_NAME);
    }

    @Override
    public Employee mapRowForSelect(ResultSet resultSet) {
        Employee employee = new Employee();

        try {
            employee.setId(resultSet.getLong(Fields.ENTITY__ID));
            employee.setLogin(resultSet.getString(Fields.EMPLOYEE__LOGIN));
            employee.setPass(resultSet.getString(Fields.EMPLOYEE__PASS));
            employee.setName(resultSet.getString(Fields.EMPLOYEE__FIRST_NAME));
            employee.setSurname(resultSet.getString(Fields.EMPLOYEE__LAST_NAME));
            employee.setRoleId(resultSet.getInt(Fields.EMPLOYEE__ROLE_ID));
            employee.setLocaleId(resultSet.getInt(Fields.EMPLOYEE__LOCALE_ID));
            log.info("Employee created");
            return employee;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Employee creation failed");
        return employee;
    }

    @Override
    protected PreparedStatement getStatementForUpdate(Employee entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getUpdateStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForInsert(Employee entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getInsertStatement(entity,connection);
    }

    @Override
    protected PreparedStatement getStatementForDelete(Employee entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getDeleteStatement(entity,connection);
    }

}
