package com.sqlsamples;

import Model.AdminTable;
import Model.Doctor;
import Model.MedicalRecord;
import Model.Patient;
import UIClasses.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Doctor> docList;
    private Doctor doctor;
    JFrame frame;
    LoginView loginView;
    AdminView adminView;
    DoctorView doctorView;
    MedicalRecordView medicalRecordView;
    PatientView patientView;
    SignupView signupView;
    WelcomeView welcomeView;

    Controller() {
        init();
    }

    private void init() {
        frame = new JFrame();
        welcomeView = new WelcomeView(this);
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(welcomeView, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public void openView(String view, Object user, int patientId) {
        frame.getContentPane().removeAll();
        switch (view) {
            case "login":
                loginView = new LoginView(this);
                frame.setSize(400, 300);
                frame.add(loginView, BorderLayout.CENTER);
                frame.setVisible(true);
                break;
            case "signup":
                signupView = new SignupView(this);
                frame.setSize(400, 300);
                frame.add(signupView, BorderLayout.CENTER);
                break;
            case "patient":
                patientView = new PatientView(this, (Patient) user);
                frame.setSize(450, 500);
                frame.add(patientView, BorderLayout.CENTER);
                break;
            case "doctor":
                doctorView = new DoctorView(this, (Doctor) user, DatabaseConnection.getAllPatients(true));
                frame.setSize(400, 300);
                frame.add(doctorView, BorderLayout.CENTER);
                break;
            case "admin":
                docList = DatabaseConnection.getDoctors();
                adminView = new AdminView(this, (AdminTable) user, docList);
                frame.setSize(600, 400);
                frame.add(adminView, BorderLayout.CENTER);
                break;
            case "medical record":
                MedicalRecord medRecord = DatabaseConnection.getMedRecord(patientId);
                if (medRecord == null) {
                    medRecord = new MedicalRecord(patientId, 0, 0, "null for now",
                            "", "", "");
                }
                medicalRecordView = new MedicalRecordView(this, medRecord, (Doctor) user);

                frame.setSize(400, 300);
                frame.add(medicalRecordView, BorderLayout.CENTER);
                break;
        }
        frame.revalidate();
        frame.repaint();
    }


    public void addDoctor(Doctor doctor) {
        DatabaseConnection.addDoctor(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        DatabaseConnection.deleteDoctor(doctor);
    }

    public ArrayList<String> getAllAppointments() {
        return DatabaseConnection.getAllAppointments();
    }

    public ArrayList<String> getAllPatients(boolean patID) {
        return DatabaseConnection.getAllPatients(patID);
    }

    public MedicalRecord getMedicalRecord(int patientID) {
        return DatabaseConnection.getMedRecord(patientID);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        DatabaseConnection.addMedicalRecord(medicalRecord);
    }

    public void addPatient(Patient patient) {
        DatabaseConnection.addPatient(patient);
    }

    public ArrayList<Doctor> getDoctorInfo() {
        return DatabaseConnection.getDoctors();
    }

    public void updatePatient(Patient patient) {
        DatabaseConnection.updatePatient(patient);
    }
}

