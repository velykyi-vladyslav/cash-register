package ua.lviv.velykyi.vladyslav.db.service;

import ua.lviv.velykyi.vladyslav.db.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface PrepareStatementService {
    //EMPLOYEES
    PreparedStatement getUpdateStatement(Employee entity, Connection connection);
    PreparedStatement getInsertStatement(Employee entity, Connection connection);
    PreparedStatement getDeleteStatement(Employee entity, Connection connection);

    //CATEGORIES
    PreparedStatement getUpdateStatement(Category entity, Connection connection);
    PreparedStatement getInsertStatement(Category entity, Connection connection);
    PreparedStatement getDeleteStatement(Category entity, Connection connection);

    //RECEIPTS
    PreparedStatement getUpdateStatement(Receipt entity, Connection connection);
    PreparedStatement getInsertStatement(Receipt entity, Connection connection);
    PreparedStatement getDeleteStatement(Receipt entity, Connection connection);

    //ROLES
    PreparedStatement getUpdateStatement(Role entity, Connection connection);
    PreparedStatement getInsertStatement(Role entity, Connection connection);
    PreparedStatement getDeleteStatement(Role entity, Connection connection);

    //PRODUCTS
    PreparedStatement getUpdateStatement(Product entity, Connection connection);
    PreparedStatement getInsertStatement(Product entity, Connection connection);
    PreparedStatement getDeleteStatement(Product entity, Connection connection);
}
