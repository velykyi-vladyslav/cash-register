package ua.lviv.velykyi.vladyslav.db.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.Fields;
import ua.lviv.velykyi.vladyslav.db.dao.GeneralDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.service.impl.DefaultPreparedStatementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends GeneralDAO<Category> {
    private static final Logger log = Logger.getLogger(CategoryDAO.class);
    private static final String TABLE_NAME = "categories";

    public CategoryDAO() {
        super();
        setTable(TABLE_NAME);
    }

    @Override
    protected Category mapRowForSelect(ResultSet resultSet) {
        try {
            Category category = new Category();

            category.setId(resultSet.getLong(Fields.ENTITY__ID));
            category.setName(resultSet.getString(Fields.ENTITY__NAME));
            log.info("Category entity has been created for select");
            return category;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Category creation for select has been failed");
        return null;
    }


    @Override
    protected PreparedStatement getStatementForDelete(Category entity, Connection connection) {
      return DefaultPreparedStatementService.getInstance().getDeleteStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForUpdate(Category entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getUpdateStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForInsert(Category entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getInsertStatement(entity, connection);
    }
}
