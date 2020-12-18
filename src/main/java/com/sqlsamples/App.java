package com.sqlsamples;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=Hej12345";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            Connection conn = DriverManager.getConnection(connectionUrl);
           if (conn != null){
               System.out.println("connection successful");
           }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
