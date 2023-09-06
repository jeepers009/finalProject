package by.itclass.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String DB_FILE_PROPS = "db.properties";
    private static Connection cn;
    private static Properties props;

    public static void init() {
        loadProps();
        loadDriver();
    }


    private static void loadProps() {
        props = PropertiesManager.getProperties(DB_FILE_PROPS);
    }

    private static void loadDriver() {
        try {
            Class.forName(props.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return cn == null || cn.isClosed()
                ? DriverManager.getConnection(props.getProperty(URL), props)
                : cn;
    }
}
