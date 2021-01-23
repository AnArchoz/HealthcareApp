package com.sqlsamples;

import Model.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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
        String query = "SELECT * FROM ADMIN_TABLE WHERE a_id=? AND ad_pw=?";
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

    public static Patient getPatientInfo(int id) {
        String query = "EXECUTE getPatient @pat_id =? ";
        Patient patient = null;

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, id);

            ResultSet results = cs.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                String firstname = results.getString(1);
                String lastname = results.getString(2);
                Date birthDate = results.getDate(3);


                patient = new Patient(id, firstname, lastname, null, null,
                        1231293, birthDate, null, null, 0);
            }

            results.close();
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    public static Appointment getAppointment(int id) {
        String query = "EXECUTE getAppointment @app_id =? ";
        Appointment app = null;

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, id);

            ResultSet results = cs.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                int pat_id = results.getInt(1);
                int dr_id = results.getInt(2);
                String app_date = results.getString(3);
                Timestamp bookTime = results.getTimestamp(4);
                Date date = new Date(bookTime.getTime());

                app = new Appointment(id, pat_id, dr_id, app_date, date);
            }

            results.close();
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return app;
    }

    public static MedicalRecord getMedRecord(int patientId) {
        String query = "EXECUTE getMedicalRecord @mc_pat_id=?";
        MedicalRecord medRecord = null;

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, patientId);

            ResultSet results = cs.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "No such patient! Idiot!");
                return null;
            } else {
                int dr_id = results.getInt(2);
                int appId = results.getInt(3);
                String appDate = results.getString(4);
                String diagnosis = results.getString(5);
                String description = results.getString(6);
                String drugs = results.getString(7);

                medRecord = new MedicalRecord(patientId, dr_id, appId, appDate, diagnosis, description, drugs);
            }

            results.close();
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medRecord;
    }

    public static ArrayList<String> getAllAppointments() {
        String query = "SELECT * FROM appInfo;";
        ArrayList<String> appList = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {

                String docFirstName = results.getString(1);
                String docLastName = results.getString(2);
                String appDate = results.getString(3);
                String patFirstName = results.getString(4);
                String patLastName = results.getString(5);

                String appString = "Dr. " + docFirstName + " " + docLastName + ", meeting with " +
                        patFirstName + " " + patLastName + " at " + appDate;

                appList.add(appString);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appList;
    }

    public static ArrayList<String> getAllPatients(boolean patID) {
        String query;
        if (!patID)
            query = "SELECT pat_id, first_name, last_name, total_cost FROM patient;";
        else
            query = "SELECT patient_id FROM appointment;";

        ArrayList<String> patientList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                String patientString = "";
                int patientId;
                if (!patID) {
                    patientId = results.getInt(1);
                    String firstName = results.getString(2);
                    String lastName = results.getString(3);
                    int totalCost = results.getInt(4);
                    patientString = firstName + " " + lastName + ", Medical ID: " + patientId + ", Total Cost: "
                            + totalCost + ":-";
                } else {
                    patientId = results.getInt(1);
                    patientString = "" + patientId;
                }
                patientList.add(patientString);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientList;
    }

    public static void addSpecialisation(Spec_list specialisation) {
        String query = "INSERT INTO spec_list VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println("TEST SPEC=" + specialisation.getSpecialisation() + specialisation.getSpecPrice());
            ps.setString(1, specialisation.getSpecialisation());
            ps.setNull(2, Types.NULL);
            ps.setInt(3, specialisation.getSpecPrice());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Spec_list> getSpecialisations() {
        String query = "SELECT * FROM spec_list;";
        ArrayList<Spec_list> speclist = new ArrayList<Spec_list>();
        Spec_list specIndividual = null;

        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {

                String specName = results.getString(1);
                int doctorId = results.getInt(2);
                int specPrice = results.getInt(3);

                specIndividual = new Spec_list(specName, null, specPrice);
                speclist.add(specIndividual);
            }

            for (Spec_list spec : speclist) {
                System.out.println(spec.getSpecialisation());
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return speclist;
    }

    public static ArrayList<Doctor> getDoctors() {
        String query = "SELECT * FROM doctor;";
        ArrayList<Doctor> docList = new ArrayList<Doctor>();
        Doctor doc = null;

        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {

                int docId = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String spec = results.getString(4);
                String password = results.getString(5);

                doc = new Doctor(docId, firstName, lastName, spec, password);
                docList.add(doc);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docList;
    }

    public static void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctor VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, doctor.getId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialisation());
            ps.setString(5, doctor.getPw());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDoctor(Doctor doctor) {
        String query = "DELETE FROM doctor WHERE d_id=?;";
        int doctorID = doctor.getId();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, doctorID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DON'T TELL ME WHAT TO DO");
        }
    }

    public static void addMedicalRecord(MedicalRecord medicalRecord) {
        String query = "INSERT INTO medical_record VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, medicalRecord.getPatientId());
            ps.setInt(2, medicalRecord.getDoctorId());
            ps.setInt(3, medicalRecord.getMrAppId());
            ps.setString(4, medicalRecord.getAppDate());
            ps.setString(5, medicalRecord.getDiagnosis());
            ps.setString(6, medicalRecord.getDescription());
            ps.setString(7, medicalRecord.getDrugs());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}