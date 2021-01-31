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

    public static User checkLogin(int id, String password, String userType) {
        User user = null;
        String query = "SELECT * FROM " + userType + " WHERE id=? AND pw=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet results = ps.executeQuery();
            String firstName = "";
            String lastName = "";

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "Wrong username and/or password!");
                return null;
            } else {
                switch (userType) {
                    case "admin_table":
                        user = (User) new AdminTable(id, password);
                        break;
                    case "patient":
                        firstName = results.getString(2);
                        lastName = results.getString(3);
                        String gender = results.getString(4);
                        String address = results.getString(5);
                        int phone = results.getInt(6);
                        Date birthDate = results.getDate(7);
                        Timestamp regDay = results.getTimestamp(8);
                        int totalCost = results.getInt(10);

                        user = new Patient(id, firstName, lastName, gender, address,
                                phone, birthDate, regDay, password, totalCost);
                        break;
                    case "doctor":
                        firstName = results.getString(2);
                        lastName = results.getString(3);
                        String spec = results.getString(4);
                        int visitCost = results.getInt(5);
                        user = new Doctor(id, firstName, lastName, spec, visitCost, password);

                }
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static ArrayList<Appointment> getAppointments(int docID) {
        String query = "EXECUTE getAppointment @doctor_id =? ";
        Appointment app = null;
        ArrayList<Appointment> appList = new ArrayList<>();

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, docID);

            ResultSet results = cs.executeQuery();

            while (results.next()) {
                Integer pat_id = results.getInt(1);
                int dr_id = results.getInt(2);
                String app_date = results.getString(3);
                Timestamp bookTime = results.getTimestamp(4);

                app = new Appointment(0, pat_id, dr_id, app_date, bookTime);
                appList.add(app);
            }

            results.close();
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appList;
    }

    public static MedicalRecord getMedRecord(int patientId, String bookDate) {
        String query = "EXECUTE getMedicalRecord @mc_id=?, @mc_app_date=?;";
        MedicalRecord medRecord = null;

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, patientId);
            cs.setString(2, bookDate);

            ResultSet results = cs.executeQuery();

            if (!results.next()) {
                JOptionPane.showMessageDialog(null, "No prior record, creating new record.");
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

    public static ArrayList<String> getPatients() {
        String query = "EXECUTE getPatients;";

        ArrayList<String> patientList = new ArrayList<>();

        try {
            CallableStatement cs = conn.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int patientId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int totalCost = rs.getInt(4);

                String patientString = firstName + " " + lastName + ", Medical ID: " + patientId + ", Total Cost: "
                        + totalCost + ":-";

                patientList.add(patientString);
            }

            cs.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientList;
    }

    // Boolean patient ID needed to select only patients with appointments, and therefore medical records
    public static ArrayList<String> getAllPatients() {
        String query;
        query = "SELECT patient_id FROM appointment;";

        ArrayList<String> patientList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                String patientString = "";
                int patientId;
                patientId = results.getInt(1);
                patientString = "" + patientId;
                if (patientId != 0)
                    patientList.add(patientString);
            }
            results.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientList;
    }

    public static ArrayList<Doctor> getDoctors() {
        String query = "SELECT * FROM doctor;";
        ArrayList<Doctor> docList = new ArrayList<Doctor>();
        Doctor doc;

        try {
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet results = ps.executeQuery();
            while (results.next()) {

                int docId = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                String spec = results.getString(4);
                int price = results.getInt(5);
                String password = results.getString(6);

                doc = new Doctor(docId, firstName, lastName, spec, price, password);
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
        String query = "INSERT INTO doctor VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, doctor.getId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialisation());
            ps.setInt(5, doctor.getVisitCost());
            ps.setString(6, doctor.getPw());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDoctor(Doctor doctor) {
        String query = "DELETE FROM doctor WHERE id=?;";
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

    public static void updateMedicalRecord(MedicalRecord medicalRecord) {
        String query = "UPDATE medical_record SET diagnosis=?, description=?, drugs=? WHERE patient_id=? AND app_date_=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, medicalRecord.getDiagnosis());
            ps.setString(2, medicalRecord.getDescription());
            ps.setString(3, medicalRecord.getDrugs());
            ps.setInt(4, medicalRecord.getPatientId());
            ps.setString(5, medicalRecord.getAppDate());


            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMedicalRecord(MedicalRecord medicalRecord) {
        String query = "INSERT INTO medical_record VALUES(?,?,?,?,?,?,?);";
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

    public static void addPatient(Patient patient) {
        String query = "INSERT INTO patient VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getFirstname());
            ps.setString(3, patient.getLastname());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPhone());
            ps.setDate(7, patient.getBirthDate());
            ps.setDate(8, new Date(patient.getRegDay().getTime()));
            ps.setString(9, patient.getPassword());
            ps.setInt(10, patient.getTotalCost());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePatient(Patient patient) {
        String query = "UPDATE patient SET first_name=?, last_name=?, gender=?, " +
                "address=?, phone=?, birth_date=?, pw=? WHERE id=?;";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, patient.getFirstname());
            ps.setString(2, patient.getLastname());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getAddress());
            ps.setInt(5, patient.getPhone());
            ps.setDate(6, patient.getBirthDate());
            String password = patient.getPassword();
            ps.setString(7, patient.getPassword());
            ps.setInt(8, patient.getPatientId());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bookAppointment(Appointment app) {
        String query = "INSERT INTO appointment VALUES(?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            if (app.getPatientId() == 0)
                ps.setNull(1, app.getAppId());
            else
                ps.setInt(1, app.getPatientId());
            ps.setInt(2, app.getDoctorId());
            ps.setString(3, app.getAppDate());
            ps.setTimestamp(4, app.getBookTime());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getAppId(int patientID, String appDate) {
        String query = "SELECT app_id FROM appointment WHERE patient_id =? AND app_date_ =?;";
        int appID = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientID);
            ps.setString(2, appDate);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                appID = rs.getInt(1);

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appID;
    }

    public static void addDebt(int patientID, int visitCost) {
        String query = "UPDATE PATIENT SET total_cost = total_cost +? WHERE id=?;";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, visitCost);
            ps.setInt(2, patientID);

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getPatientInfo(int patientID) {
        String query = "EXECUTE getPatientInfo @id =?";
        String patientString = "";

        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, patientID);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String birthDate = rs.getDate(3).toString();
                String gender = rs.getString(4);
                String address = rs.getString(5);
                String phoneString = "0" + rs.getInt(6);
                Timestamp regDate = rs.getTimestamp(7);
                Date reg = new Date(regDate.getTime());
                String regString = reg.toString();
                int totalCost = rs.getInt(8);

                patientString = "Full name: " + firstName + " " + lastName + ", Medical ID: " + patientID
                        + "\n Date of birth: " + birthDate + ", Gender: " + gender
                        + "\n address: " + address + ", Phone number: " + phoneString
                        + "\n Registration date: " + regString + " Total Cost: " + +totalCost + ":-";

            }

            cs.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientString;
    }
}