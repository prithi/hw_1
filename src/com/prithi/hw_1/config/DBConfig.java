package com.prithi.hw_1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class DBConfig {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/EMP";

    static final String USER = "root";
    static final String PASS = "121361";

    public Connection dbConnect() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to Databse...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }


}
