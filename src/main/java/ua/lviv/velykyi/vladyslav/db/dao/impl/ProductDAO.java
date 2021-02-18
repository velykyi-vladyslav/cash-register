package ua.lviv.velykyi.vladyslav.db.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.Fields;
import ua.lviv.velykyi.vladyslav.db.dao.GeneralDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Product;
import ua.lviv.velykyi.vladyslav.db.service.impl.DefaultPreparedStatementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends GeneralDAO<Product> {
    private static final Logger log = Logger.getLogger(RoleDAO.class);
    private static final String TABLE_NAME = "products";

    public ProductDAO() {
        super();
        setTable(TABLE_NAME);
    }
    @Override
    protected Product mapRowForSelect(ResultSet resultSet) {
        Product product = new Product();

        try {
            product.setId(resultSet.getLong(Fields.ENTITY__ID));
            product.setName(resultSet.getString(Fields.ENTITY__NAME));
            product.setPrice(resultSet.getBigDecimal(Fields.PRODUCT__PRICE));
            product.setCategoryId(resultSet.getLong(Fields.PRODUCT__CATEGORY_ID));
            log.info("Product has been created");
            return product;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Product`s creation failed");
        return product;
    }

    @Override
    protected PreparedStatement getStatementForUpdate(Product entity, Connection connection) {
        return  DefaultPreparedStatementService.getInstance().getUpdateStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForInsert(Product entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getInsertStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForDelete(Product entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getDeleteStatement(entity, connection);
    }
}
