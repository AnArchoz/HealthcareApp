package com.sqlsamples;

import Model.AdminTable;
import Model.Doctor;
import Model.Patient;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    private static Connection conn;

    DatabaseConnection() {
        String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=master;user=bla;password=Hej12345";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            conn = DriverManager.getConnection(connectionUrl);
            if (conn != null) {
                System.out.println("connection successful");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }


    }

    public static Doctor checkDoctorLogin(int id, String password) {
        String query = "SELECT * FROM DOCTOR WHERE d_id=? AND d_pw=?";
        Doctor doctor = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet results = ps.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                String firstname = results.getString(2);
                String lastname = results.getString(3);
                String spec = results.getString(4);
                doctor = new Doctor(id, firstname, lastname, spec, password);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public static Patient checkPatientLogin(int id, String password) {
        String query = "SELECT * FROM PATIENT WHERE pat_id=? AND p_pw=?";
        Patient patient = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet results = ps.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                String firstname = results.getString(2);
                String lastname = results.getString(3);
                String gender = results.getString(4);
                String address = results.getString(5);
                int phone = results.getInt(6);
                Date birthDate = results.getDate(7);
                String regDay = results.getString(8);

                patient = new Patient(id, firstname, lastname, gender, address,
                        phone, birthDate, regDay, password, 0);
            }

            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    public static AdminTable checkAdminLogin(int id, String password) {
        String query = "SELECT * FROM ADMINTABLE WHERE a_id=? AND ad_pw=?";
        AdminTable admin = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet results = ps.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                admin = new AdminTable(id, password);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
