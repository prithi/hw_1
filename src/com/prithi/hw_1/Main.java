package com.prithi.hw_1;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/EMP";

    static final String USER = "root";
    static final String PASS = "121361";


    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null;

        /*
        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        */

        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to Databse...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement");
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT id, first, last, age FROM Employees";

            System.out.println("Enter ID");
            int id = kb.nextInt();


            System.out.println("Enter First Name");
            String first = kb.next();
            first = "'"+first+"'";


            System.out.println("Enter Lase Name");
            String last = kb.next();
            last = "'"+last+"'";

            System.out.println("Enter Age");
            int age = kb.nextInt();



            String sqlInsert = "Insert into Employees " + "values (" + id + ", " + age + ", " + first + ", " + last + ")";
            System.out.println("The SQL query is: " + sqlInsert);

            int countInserted = stmt.executeUpdate(sqlInsert);

            System.out.println(countInserted + " records inserted.\n");

            ResultSet rs = stmt.executeQuery(sql);

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

            /*
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

            }*/
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException e){

            }
            try {
                if (conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Goodbye!");
    }
}
