package by.itclass.model.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String DB_FILE_PROPS = "src\\main\\resources\\db.properties";
    private static Connection cn;
    private static Properties props;

    public static void init() throws IOException, ClassNotFoundException {
        loadProps();
        loadDriver();
    }


    private static void loadProps() throws IOException {
        props = PropertiesManager.getProperties(DB_FILE_PROPS);
    }

    private static void loadDriver() throws ClassNotFoundException {
        Class.forName(props.getProperty(DRIVER));
    }

    public static Connection getConnection() throws SQLException {
        return cn == null || cn.isClosed()
                ? DriverManager.getConnection(props.getProperty(URL), props)
                : cn;
    }
}
