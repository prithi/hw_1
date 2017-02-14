package com.prithi.hw_1.dao;

import com.prithi.hw_1.config.DBConfig;
import com.prithi.hw_1.domain.EmployeePOJO;

import java.sql.*;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class EmployeeDao {

    Statement stmt = null;


    public EmployeeDao createStmt() throws SQLException, ClassNotFoundException {
        DBConfig dbConfig = new DBConfig();
        Connection conn = dbConfig.initialize();
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.stmt = conn.createStatement();
        return employeeDao;
    }

    public void insert(int id, int age, String firstName, String lastName) throws SQLException {
        String sql = "Insert into Employees " + "values (" + id + ", " + age + ", " + firstName + ", " + lastName + ")";
        ResultSet rs = stmt.executeQuery(sql);
        rs.close();
    }

    public void read(){}

    public static void save(EmployeePOJO employeePOJO){
        int id = employeePOJO.getId();
        int age = employeePOJO.getAge();
        String firstName = employeePOJO.getFirstName();
        String lastName = employeePOJO.getLastName();

        EmployeeDao employeeDao = new EmployeeDao();
        try {
            employeeDao = employeeDao.createStmt();
            employeeDao.insert(id, age, firstName, lastName);
            employeeDao.stmt.close();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void viewAll() throws SQLException, ClassNotFoundException {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao = employeeDao.createStmt();
        String sql;
        sql = "SELECT id, first, last, age FROM Employees";

        ResultSet rs = employeeDao.stmt.executeQuery(sql);

        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int numberOfColumns = resultSetMetaData.getColumnCount();

        System.out.printf("Employees Database:%n%n");

        for (int i=1; i<= numberOfColumns; i++){
            System.out.printf("%-8s\t", resultSetMetaData.getColumnName(i));
        }
        System.out.println();

        while (rs.next()){
            for(int i=1; i<=numberOfColumns; i++){
                System.out.printf("%-8s\t", rs.getObject(i));
            }
            System.out.println();
        }

        rs.close();
        employeeDao.stmt.close();


    }
}
