/*
 * Created by JFormDesigner on Mon Dec 21 18:02:04 CET 2020
 */

package UIClasses;

import Model.Doctor;
import Model.Patient;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author ANTO O ELNI
 */
public class PatientView extends JPanel {
    private Controller controller;

    public PatientView(Controller controller, Patient patient) {
        this.controller = controller;
        initComponents();
        updateComponents(patient);
        System.out.println(patient);
    }

    private void updateComponents(Patient patient) {
        int patientID = patient.getPatientId();
        String firstName = patient.getFirstname();
        String lastName = patient.getLastname();
        String address = patient.getAddress();
        String gender = patient.getGender();
        int phone = patient.getPhone();
        Date birthDate = patient.getBirthDate();

        Date regDate = new Date(patient.getRegDay().getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format.format(regDate);
        ArrayList<Doctor> doctorInfo = controller.getDoctorInfo();
        System.out.println(patient);

        DefaultComboBoxModel<Doctor> model = new DefaultComboBoxModel<>();
        for (Doctor doc : doctorInfo) {
            model.addElement(doc);
        }

        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        addressField.setText(address);
        genderField.setText(gender);
        phoneField.setText("" + phone);
        doctorListBox.setModel(model);
        patientNameLbl.setText("" + patientID);
        dateLbl.setText(birthDate.toString());
        regDateLbl.setText("Registration date: " + regDate.toString());
    }

    private void saveInfo(ActionEvent e) {
        int patientID = Integer.parseInt(patientNameLbl.getText());
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

        controller.updatePatient(patient);
    }

    private void seeTimes(ActionEvent e) {
        Doctor doc = (Doctor) doctorListBox.getSelectedItem();

        if (doc != null) {
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String time : doc.getFreeTimes()) {
                model.addElement(time);
            }
            doctorTimeList.setModel(model);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Patrick Andersson
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
        scrollPane2 = new JScrollPane();
        doctorTimeList = new JList();
        timesBtn = new JButton();
        selectedDoctorLbl = new JLabel();
        availableTimeLbl = new JLabel();
        makeAppBtn = new JButton();
        saveInfoBtn = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );

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
        passwordLbl.setText("Password - 8 digits");

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

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(doctorTimeList);
        }

        //---- timesBtn ----
        timesBtn.setText("See available times");
        timesBtn.addActionListener(e -> seeTimes(e));

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
                    .addGap(86, 86, 86)
                    .addComponent(regDateLbl)
                    .addGap(65, 65, 65)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(dateLbl)
                        .addComponent(patientNameLbl, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                        .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(genderField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phoneLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(genderLbl)
                                                .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(doctorListLbl)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(selectedDoctorLbl)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(passwordLbl)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(addressLbl))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(saveInfoBtn))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(timesBtn)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 7, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(makeAppBtn, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
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
                                            .addGap(15, 15, 15)))
                                    .addGap(0, 141, Short.MAX_VALUE)))
                            .addGap(143, 143, 143))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(availableTimeLbl)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regDateLbl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientNameLbl))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(lastnameLbl)
                        .addComponent(firstnameLbl)
                        .addComponent(dateLbl))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(genderLbl)
                        .addComponent(passwordLbl, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(genderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(phoneLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(saveInfoBtn))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addressLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(availableTimeLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(doctorListLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(selectedDoctorLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(timesBtn)
                                .addComponent(makeAppBtn))))
                    .addContainerGap(2, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
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
    private JScrollPane scrollPane2;
    private JList doctorTimeList;
    private JButton timesBtn;
    private JLabel selectedDoctorLbl;
    private JLabel availableTimeLbl;
    private JButton makeAppBtn;
    private JButton saveInfoBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
