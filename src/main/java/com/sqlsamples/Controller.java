package com.sqlsamples;

import Model.AdminTable;
import Model.Doctor;
import Model.Patient;
import Model.Spec_list;
import UIClasses.*;
import UIClasses.LoginView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller {
    private Doctor doctor;
    private ArrayList<Spec_list> specList;
    private ArrayList<Doctor> docList;
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

    public void openView(String view, Object user) {
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
                doctorView = new DoctorView(this, (Doctor) user);
                frame.setSize(400, 300);
                frame.add(doctorView, BorderLayout.CENTER);
                break;
            case "admin":
                specList = DatabaseConnection.getSpecialisations();
                docList = DatabaseConnection.getDoctors();
                adminView = new AdminView(this, (AdminTable) user, specList, docList);
                frame.setSize(600, 400);
                frame.add(adminView, BorderLayout.CENTER);
                break;
            case "medical record":
                medicalRecordView = new MedicalRecordView(this);
                frame.setSize(400, 300);
                frame.add(medicalRecordView, BorderLayout.CENTER);
                break;
        }
        frame.revalidate();
        frame.repaint();
    }

    public void testProcedure() {
        System.out.println(DatabaseConnection.getAppointment(1).toString());
    }

    public void addSpec(Spec_list spec) {
        DatabaseConnection.addSpecialisation(spec);
    }

    public void addDoctor(Doctor doctor) {
        DatabaseConnection.addDoctor(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        DatabaseConnection.deleteDoctor(doctor);
    }


}