package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
    private static Connection connection;
    private static DBConnectionManager dbConnectionManager_instance = null;
    private static Properties properties;
    private static String url;

    private DBConnectionManager(String dbURL) {
        Properties dbProperties = new Properties();
        try {
            Class.forName("util.Secret");
            Secret.setPass(dbProperties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Secret with credentials not found!");
            throw new ConnectionException(e);
        }
        dbProperties.setProperty("ssl", "true");
        dbProperties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        dbProperties.setProperty("sslmode", "prefer");

        properties = dbProperties;
        url = dbURL;

        setConnection();
    }

    public static DBConnectionManager getInstance(String dbURL) {
        if(dbConnectionManager_instance == null) {
            dbConnectionManager_instance = new DBConnectionManager(dbURL);
        }
        return dbConnectionManager_instance;
    }

    public Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()) setConnection();
        } catch (SQLException throwables) {
            throw new ConnectionException(throwables);
        }
        return connection;
    }
    private static void setConnection() {
        try {
            System.out.println("reconnecting to database ...");
            Class.forName("org.postgresql.Driver");
            System.out.println("url:"+url);
            connection = DriverManager.getConnection(url, properties);
            System.out.println("done");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("connection troubles");
            throw new ConnectionException(e);
        }
    }
}

