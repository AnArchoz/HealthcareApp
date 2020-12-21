package com.sqlsamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=master;user=bla;password=Hej12345";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            Connection conn = DriverManager.getConnection(connectionUrl);
           if (conn != null){
               System.out.println("connection successful");
               Statement st = conn.createStatement();
               st.executeUpdate("INSERT INTO doctor VALUES (133, 'ant', 'man', 'PW', 2, 12345)" );
           }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
