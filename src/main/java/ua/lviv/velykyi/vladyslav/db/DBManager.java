package ua.lviv.velykyi.vladyslav.db;

import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;


public class DBManager {
    private static final Logger log = Logger.getLogger(DBManager.class);

    private static DBManager instance;
    private String url;

    public static DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            // ST4DB - the name of data source
            DataSource ds = (DataSource)envContext.lookup("jdbc/cash_register");
            con = ds.getConnection();
        } catch (NamingException ex) {
            log.error("Cannot obtain a connection from the pool", ex);
        }
        return con;
    }

    private void setUrl() {
        try (FileReader fin = new FileReader("app.properties")) {
            Properties pr = new Properties();
            pr.load(fin);
            url = pr.getProperty("connection.url");
            log.info("Set url");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public Connection getConnectionWithDM() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cash_register?user=velykyi&password=1928528375");
    }

    private DBManager() {
        //setUrl();
    }
}
