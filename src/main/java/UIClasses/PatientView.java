/*
 * Created by JFormDesigner on Mon Dec 21 18:02:04 CET 2020
 */

package UIClasses;

import Model.Appointment;
import Model.Doctor;
import Model.MedicalRecord;
import Model.Patient;
import com.sqlsamples.Controller;
import wrapper.BoundsPopupMenuListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author ANTO O ELNI
 */
public class PatientView extends JPanel {
    private Controller controller;
    private DefaultComboBoxModel<Doctor> docModel;

    public PatientView(Controller controller, Patient patient) {
        this.controller = controller;
        initComponents();
        updateComponents(patient);
        System.out.println(patient);
    }

    private void updateComponents(Patient patient) {
        Calendar todaysDate = Calendar.getInstance(TimeZone.getDefault());
        //int currentDay = todaysDate.get(Calendar.DAY_OF_WEEK);
        // TODO: ENABLE BEFORE PRESENTATION LMAO
        //boolean isFriday = (currentDay == Calendar.FRIDAY);
        //if (!isFriday) {
        //    makeAppBtn.setEnabled(false);
        //    makeAppBtn.setText("ONLY FRIDAYS");
        //}

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
        ArrayList<Appointment> appList;
        System.out.println(patient);

        DefaultComboBoxModel<Doctor> model = new DefaultComboBoxModel<>();
        for (Doctor doc : doctorInfo) {
            model.addElement(doc);
            appList = controller.getDoctorAppointments(doc.getId());
            for (Appointment app : appList)
                doc.book(app.getAppDate());
        }

        BoundsPopupMenuListener listener = new BoundsPopupMenuListener(true, false);
        doctorListBox.addPopupMenuListener(listener);

        docModel = model;
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        addressField.setText(address);
        genderField.setText(gender);
        phoneField.setText("" + phone);
        doctorListBox.setModel(model);
        patientNameLbl.setText("" + patientID);
        dateLbl.setText(birthDate.toString());
        birthdayField.setText(birthDate.toString());
        passwordField1.setText(patient.getPassword());
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
        String password = "";
        if (passwordField1.getPassword() == null)
            JOptionPane.showMessageDialog(null, "EMPTY PASSWORD IDIOT");
        else
            password = new String(passwordField1.getPassword());
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

    private void makeAppointment(ActionEvent e) {
        int index = doctorTimeList.getSelectedIndex();
        String selectedDate = doctorTimeList.getSelectedValue().toString();
        DefaultListModel<String> model;
        model = (DefaultListModel) doctorTimeList.getModel();
        model.removeElementAt(index);

        Doctor doctor = (Doctor) doctorListBox.getSelectedItem();
        int doctorID = -1;
        if (doctor != null) {
            doctorID = doctor.getId();
            doctor.book(selectedDate);
        }

        int patientID = Integer.parseInt(patientNameLbl.getText());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Appointment app = new Appointment(0, patientID, doctorID, selectedDate, timestamp);
        controller.bookAppointment(app);

        int appID = controller.getAppID(patientID, selectedDate);
        MedicalRecord medicalRecord = new MedicalRecord(patientID, doctorID, appID,
                selectedDate, "", "", "");
        controller.addMedicalRecord(medicalRecord);
        controller.addDebt(patientID, doctor.getVisitCost());
    }

    private void filterDoctors(ActionEvent e) {
        String spec = filterDoctorField.getText().toLowerCase();
        filterDoctorField.setText("");
        DefaultComboBoxModel<Doctor> model = (DefaultComboBoxModel) doctorListBox.getModel();
        ArrayList<Doctor> docList = new ArrayList<>();

        int modelSize = model.getSize();
        for (int i = 0; i < modelSize; i++) {
            docList.add(model.getElementAt(i));
        }

        for (int i = model.getSize() - 1; i >= 0; i--) {
            Doctor doc = model.getElementAt(i);
            String docSpec = doc.getSpecialisation().toLowerCase();

            if (!docSpec.equals(spec)) {
                model.removeElement(doc);
            }
        }

        if (model.getSize() == 0) {
            JOptionPane.showMessageDialog(null, "NO SUCH SPECIALISATION, TRY AGAIN");
            doctorListBox.setModel(docModel);
            for (Doctor doc : docList)
                model.addElement(doc);
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
        scrollPane2 = new JScrollPane();
        doctorTimeList = new JList();
        timesBtn = new JButton();
        selectedDoctorLbl = new JLabel();
        availableTimeLbl = new JLabel();
        makeAppBtn = new JButton();
        saveInfoBtn = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        filterDoctorField = new JTextField();
        filterButton = new JButton();
        doctorListLbl = new JLabel();
        doctorListBox = new JComboBox();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                swing.border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border
                .TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog"
                , java.awt.Font.BOLD, 12), java.awt.Color.red), getBorder
                ()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java
                                               .beans.PropertyChangeEvent e) {
                if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException
                        ();
            }
        });

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
        makeAppBtn.addActionListener(e -> makeAppointment(e));

        //---- saveInfoBtn ----
        saveInfoBtn.setText("Save info");
        saveInfoBtn.addActionListener(e -> saveInfo(e));

        //---- label1 ----
        label1.setText("Week/Time/Day");

        //---- label2 ----
        label2.setText("Filter doctor by Specialisation");

        //---- filterButton ----
        filterButton.setText("Filter");
        filterButton.addActionListener(e -> filterDoctors(e));

        //---- doctorListLbl ----
        doctorListLbl.setText("List of all doctors");

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
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(label2)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(label1)
                                                                        .addComponent(availableTimeLbl)))
                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(phoneLbl, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup()
                                                                                        .addComponent(genderLbl)
                                                                                        .addComponent(genderField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(passwordLbl)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup()
                                                                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(addressLbl)))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(saveInfoBtn))))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(filterDoctorField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(17, 17, 17)
                                                                                .addComponent(filterButton))
                                                                        .addComponent(selectedDoctorLbl)
                                                                        .addComponent(doctorListLbl)
                                                                        .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(timesBtn, GroupLayout.Alignment.TRAILING))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(makeAppBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(119, 119, 119))))
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
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(genderLbl)
                                                        .addComponent(passwordLbl))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(genderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(phoneLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(saveInfoBtn)
                                                        .addComponent(addressLbl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(availableTimeLbl))
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(filterDoctorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filterButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(doctorListLbl)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectedDoctorLbl)
                                                .addGap(2, 2, 2)
                                                .addComponent(timesBtn)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(label1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(makeAppBtn)
                                                .addGap(12, 12, 12))))
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
    private JScrollPane scrollPane2;
    private JList doctorTimeList;
    private JButton timesBtn;
    private JLabel selectedDoctorLbl;
    private JLabel availableTimeLbl;
    private JButton makeAppBtn;
    private JButton saveInfoBtn;
    private JLabel label1;
    private JLabel label2;
    private JTextField filterDoctorField;
    private JButton filterButton;
    private JLabel doctorListLbl;
    private JComboBox doctorListBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
