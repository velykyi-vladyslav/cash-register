package ua.lviv.velykyi.vladyslav.db.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.Fields;
import ua.lviv.velykyi.vladyslav.db.dao.GeneralDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Role;
import ua.lviv.velykyi.vladyslav.db.service.impl.DefaultPreparedStatementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO extends GeneralDAO<Role> {
    private static final Logger log = Logger.getLogger(RoleDAO.class);
    private static final String TABLE_NAME = "roles";

    public RoleDAO() {
        super();
        setTable(TABLE_NAME);
    }

    @Override
    protected Role mapRowForSelect(ResultSet resultSet) {
        Role role = new Role();
        try {
            role.setId(resultSet.getLong(Fields.ENTITY__ID));
            role.setName(resultSet.getString(Fields.ENTITY__NAME));
            log.info("Role entity has been created for select");
            return role;
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.error("Role creation for select has been failed");
        return role;
    }

    @Override
    protected PreparedStatement getStatementForUpdate(Role entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getUpdateStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForInsert(Role entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getInsertStatement(entity, connection);
    }

    @Override
    protected PreparedStatement getStatementForDelete(Role entity, Connection connection) {
        return DefaultPreparedStatementService.getInstance().getDeleteStatement(entity, connection);
    }
}
