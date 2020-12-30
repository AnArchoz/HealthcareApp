/*
 * Created by JFormDesigner on Mon Dec 21 18:02:04 CET 2020
 */

package UIClasses;

import Model.Patient;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Date;

/**
 * @author unknown
 */
public class PatientView extends JPanel {
    private Controller controller;
    private Patient patient;

    public PatientView(Controller controller, Patient patient) {
        this.controller = controller;
        this.patient = patient;
        initComponents();
    }

    private void saveInfo(ActionEvent e) {
        int patientID = 0;
        String firstName = firstNameField.getText();
        String lastname = lastNameField.getText();
        String gender = genderField.getText();
        int phoneNmbr = Integer.parseInt(phoneField.getText());
        String birthDateString = birthdayField.getText();
        Date birthDate = Date.valueOf(birthDateString);
        String password = new String(passwordField1.getPassword());
        String address = addressField.getText();

        Patient patient = new Patient(patientID, firstName, lastname, gender, address, phoneNmbr,
                birthDate, null, password, 0);

        //DatabaseConnection.addPatient(patient);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        patientNameLbl = new JLabel();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        genderField = new JTextField();
        scrollPane1 = new JScrollPane();
        addressField = new JTextPane();
        addressLbl = new JLabel();
        phoneField = new JTextField();
        birthdayField = new JTextField();
        dateLbl = new JLabel();
        passwordField1 = new JPasswordField();
        regDateLbl = new JLabel();
        passwordLbl = new JLabel();
        firstnameLbl = new JLabel();
        lastnameLbl = new JLabel();
        genderLbl = new JLabel();
        phoneLbl = new JLabel();
        doctorListBox = new JComboBox();
        doctorListLbl = new JLabel();
        specSearchLbl = new JLabel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        specSearchField = new JTextField();
        timesBtn = new JButton();
        selectedDoctorLbl = new JLabel();
        availableTimeBox = new JComboBox();
        availableTimeLbl = new JLabel();
        makeAppBtn = new JButton();
        saveInfoBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
        ();}});

        //---- patientNameLbl ----
        patientNameLbl.setText("Patient name");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(addressField);
        }

        //---- addressLbl ----
        addressLbl.setText("Address");

        //---- dateLbl ----
        dateLbl.setText("yyyy-mm-dd");

        //---- regDateLbl ----
        regDateLbl.setText("Registration date");

        //---- passwordLbl ----
        passwordLbl.setText("Password - 6 digits");

        //---- firstnameLbl ----
        firstnameLbl.setText("First name");

        //---- lastnameLbl ----
        lastnameLbl.setText("Last name");

        //---- genderLbl ----
        genderLbl.setText("Gender - 1 character");

        //---- phoneLbl ----
        phoneLbl.setText("Phone number");

        //---- doctorListLbl ----
        doctorListLbl.setText("List of doctors");

        //---- specSearchLbl ----
        specSearchLbl.setText("Search specialisation");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list1);
        }

        //---- timesBtn ----
        timesBtn.setText("See available times");

        //---- selectedDoctorLbl ----
        selectedDoctorLbl.setText("Selected doctor");

        //---- availableTimeLbl ----
        availableTimeLbl.setText("Available times");

        //---- makeAppBtn ----
        makeAppBtn.setText("Make appointment");

        //---- saveInfoBtn ----
        saveInfoBtn.setText("Save info");
        saveInfoBtn.addActionListener(e -> saveInfo(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(doctorListLbl, GroupLayout.Alignment.LEADING)
                                .addComponent(doctorListBox, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(selectedDoctorLbl)
                                        .addComponent(specSearchLbl)
                                        .addComponent(specSearchField, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timesBtn)
                                        .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(saveInfoBtn))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(availableTimeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(availableTimeLbl)
                                                .addComponent(makeAppBtn)))))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(phoneLbl)
                                    .addGap(111, 111, 111)
                                    .addComponent(addressLbl))
                                .addComponent(genderField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(firstnameLbl)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lastnameLbl)
                                            .addGap(15, 15, 15))))
                                .addComponent(genderLbl, GroupLayout.Alignment.LEADING))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(regDateLbl)
                                    .addGap(87, 87, 87)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(patientNameLbl, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(birthdayField, GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(dateLbl)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordLbl)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(71, 71, 71)))))
                    .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regDateLbl)
                        .addComponent(patientNameLbl))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(dateLbl, GroupLayout.Alignment.TRAILING)
                        .addComponent(lastnameLbl)
                        .addComponent(firstnameLbl))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(genderLbl)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(genderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(passwordLbl)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneLbl)
                        .addComponent(addressLbl))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(saveInfoBtn)))
                    .addGap(18, 18, 18)
                    .addComponent(doctorListLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(specSearchLbl)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(specSearchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(selectedDoctorLbl)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(timesBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(availableTimeLbl)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(availableTimeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(makeAppBtn)))
                            .addContainerGap(36, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel patientNameLbl;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField genderField;
    private JScrollPane scrollPane1;
    private JTextPane addressField;
    private JLabel addressLbl;
    private JTextField phoneField;
    private JTextField birthdayField;
    private JLabel dateLbl;
    private JPasswordField passwordField1;
    private JLabel regDateLbl;
    private JLabel passwordLbl;
    private JLabel firstnameLbl;
    private JLabel lastnameLbl;
    private JLabel genderLbl;
    private JLabel phoneLbl;
    private JComboBox doctorListBox;
    private JLabel doctorListLbl;
    private JLabel specSearchLbl;
    private JScrollPane scrollPane2;
    private JList list1;
    private JTextField specSearchField;
    private JButton timesBtn;
    private JLabel selectedDoctorLbl;
    private JComboBox availableTimeBox;
    private JLabel availableTimeLbl;
    private JButton makeAppBtn;
    private JButton saveInfoBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
