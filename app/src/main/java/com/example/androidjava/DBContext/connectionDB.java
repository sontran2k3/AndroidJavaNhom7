package com.example.androidjava.DBContext;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
    // JDBC driver class
    private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";

    // Database connection parameters
    private static final String IP = "192.168.123.70";
    private static final String PORT = "1433";
    private static final String DATABASE = "java";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234";

    // Method to create a connection
    public boolean connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String connectionUrl;

        try {
            // Load the JDBC driver
            Class.forName(DRIVER);
            // Build the connection URL
            connectionUrl = "jdbc:jtds:sqlserver://" + IP + ":" + PORT + ";databaseName=" + DATABASE;
            // Establish the connection
            conn = DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
