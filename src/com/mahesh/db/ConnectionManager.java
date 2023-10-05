package com.mahesh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

    private static ConnectionManager instance;
    private Connection connection;
    private String DBURL;
    private String DBUserName;
    private String DBPassword;
    private String DefaultDataBase;

    private ConnectionManager() {

        if (instance == null) {
            DBURL = "localhost:3306";
            DBUserName = "root";
            DBPassword = "123";
            DefaultDataBase = "cea";

            instance = this;

        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            new ConnectionManager();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            createConnection();
        } else if (!connection.isClosed()) {
            createConnection();
        }
        return connection;

    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            DBErrorHandlers.SQLException(ex);
        }

    }

    private void createConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + DBURL + "/" + DefaultDataBase, DBUserName, DBPassword);

        } catch (ClassNotFoundException ex) {
            DBErrorHandlers.DriverFailError(ex);
        }
    }
}
