package ua.lviv.velykyi.vladyslav.db.dao;

import ua.lviv.velykyi.vladyslav.db.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.lviv.velykyi.vladyslav.db.constant.SQLConstant.*;

public abstract class GeneralDAO<T> {
    private String table;

    protected abstract T mapRowForSelect(ResultSet resultSet);

    protected abstract PreparedStatement getStatementForUpdate(T entity, Connection connection);

    protected abstract PreparedStatement getStatementForInsert(T entity, Connection connection);

    protected abstract PreparedStatement getStatementForDelete(T entity, Connection connection);


    public List<T> findAll() {
        List<T> entities = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnectionWithDM();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT + table)) {

            while (resultSet.next()) {
                entities.add(mapRowForSelect(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return entities;
    }

    public void update(T entity) {
        try (Connection connection = DBManager.getInstance().getConnectionWithDM();
             PreparedStatement preparedStatement = getStatementForUpdate(entity, connection)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(T entity) {
        try (Connection connection = DBManager.getInstance().getConnectionWithDM();
             PreparedStatement preparedStatement = getStatementForDelete(entity, connection)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(T entity) {
        try (Connection connection = DBManager.getInstance().getConnectionWithDM();
             PreparedStatement preparedStatement = getStatementForInsert(entity, connection)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void setTable(String table) {
        this.table = table;
    }

}
