package ua.lviv.velykyi.vladyslav.db.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.DBManager;
import ua.lviv.velykyi.vladyslav.db.entity.*;
import ua.lviv.velykyi.vladyslav.db.service.PrepareStatementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static ua.lviv.velykyi.vladyslav.db.constant.SQLConstant.*;

public class DefaultPreparedStatementService implements PrepareStatementService {
    private static DefaultPreparedStatementService instance;
    private static final Logger log = Logger.getLogger(DBManager.class);

    private DefaultPreparedStatementService() {
    }

    public static DefaultPreparedStatementService getInstance() {
        if (instance == null)
            instance = new DefaultPreparedStatementService();
        return instance;
    }

    //  EMPLOYEE
    @Override
    public PreparedStatement getUpdateStatement(Employee employee, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EMPLOYEES_UPDATE);
            preparedStatement.setString(1, employee.getLogin());
            preparedStatement.setString(2, employee.getPass());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getSurname());
            preparedStatement.setLong(5, employee.getRoleId());
            preparedStatement.setLong(6, employee.getLocaleId());
            preparedStatement.setLong(7, employee.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getInsertStatement(Employee employee, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EMPLOYEES_INSERT);
            preparedStatement.setString(1, employee.getLogin());
            preparedStatement.setString(2, employee.getPass());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getSurname());
            preparedStatement.setLong(5, employee.getRoleId());
            preparedStatement.setLong(6, employee.getLocaleId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getDeleteStatement(Employee employee, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EMPLOYEES_DELETE);
            preparedStatement.setLong(1, employee.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    //   ROLE
    @Override
    public PreparedStatement getUpdateStatement(Role role, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ROLES_UPDATE);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setLong(2, role.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getInsertStatement(Role role, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ROLES_INSERT);
            preparedStatement.setString(1, role.getName());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getDeleteStatement(Role role, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ROLES_DELETE);
            preparedStatement.setLong(1, role.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    // PRODUCT
    @Override
    public PreparedStatement getUpdateStatement(Product product, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_PRODUCTS_UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setLong(4, product.getCategoryId());
            preparedStatement.setLong(5, product.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getInsertStatement(Product product, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_PRODUCTS_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setLong(4, product.getCategoryId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getDeleteStatement(Product entity, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_PRODUCTS_DELETE);
            preparedStatement.setLong(1, entity.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    // RECEIPT
    @Override
    public PreparedStatement getUpdateStatement(Receipt receipt, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_RECEIPTS_UPDATE);
            preparedStatement.setBigDecimal(1, receipt.getBill());
            preparedStatement.setLong(2, receipt.getEmployeeId());
            preparedStatement.setLong(3, receipt.getStatusId());
            preparedStatement.setLong(4, receipt.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getInsertStatement(Receipt receipt, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_RECEIPTS_INSERT);
            preparedStatement.setBigDecimal(1, receipt.getBill());
            preparedStatement.setLong(2, receipt.getEmployeeId());
            preparedStatement.setLong(3, receipt.getStatusId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getDeleteStatement(Receipt receipt, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_RECEIPTS_DELETE);
            preparedStatement.setLong(1, receipt.getId());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }


    // CATEGORY
    @Override
    public PreparedStatement getInsertStatement(Category category, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CATEGORIES_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getName());
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getDeleteStatement(Category category, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CATEGORIES_DELETE);
            preparedStatement.setString(1, category.getName());
            log.info("Statement is created");
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }

    @Override
    public PreparedStatement getUpdateStatement(Category category, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CATEGORIES_UPDATE);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setLong(2, category.getId());
            return preparedStatement;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Nullable here");
        return null;
    }
}
