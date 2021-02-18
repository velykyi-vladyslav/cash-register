package ua.lviv.velykyi.vladyslav.db;

import org.apache.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;
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
        return DriverManager.getConnection(url);
    }

    private DBManager() {
        setUrl();
    }
}
