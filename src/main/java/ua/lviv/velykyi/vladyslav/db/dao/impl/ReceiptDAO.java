package ua.lviv.velykyi.vladyslav.db.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.Fields;
import ua.lviv.velykyi.vladyslav.db.dao.GeneralDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Receipt;
import ua.lviv.velykyi.vladyslav.db.service.impl.DefaultPreparedStatementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDAO extends GeneralDAO<Receipt> {
    private static final Logger log = Logger.getLogger(GeneralDAO.class);

    protected Receipt mapRowForSelect(ResultSet resultSet) {
        try {
            Receipt receipt = new Receipt();
            receipt.setId(resultSet.getLong(Fields.ENTITY__ID));
            receipt.setBill(resultSet.getBigDecimal(Fields.RECEIPT__BILL));
            receipt.setStatusId(resultSet.getLong(Fields.RECEIPT__STATUS_ID));
            receipt.setEmployeeId(resultSet.getLong(Fields.RECEIPT__EMPLOYEE_ID));
            log.info("Receipt object created");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Employee creation failed");
        return null;
    }

    @Override
    protected PreparedStatement getStatementForUpdate(Receipt entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getUpdateStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForInsert(Receipt entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getInsertStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForDelete(Receipt entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getDeleteStatement(entity, connection);
    }


}
