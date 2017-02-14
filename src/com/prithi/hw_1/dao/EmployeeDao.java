package com.prithi.hw_1.dao;

import com.prithi.hw_1.config.DBConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class EmployeeDao {

    Statement stmt = null;


    public void createStmt() throws SQLException, ClassNotFoundException {
        DBConfig dbConfig = new DBConfig();
        Connection conn = dbConfig.dbConnect();
        stmt = conn.createStatement();
    }

    public void insert(){
        String sql = "SELECT id, first, last, age FROM Employees";
    }

    public void read(){}
}
