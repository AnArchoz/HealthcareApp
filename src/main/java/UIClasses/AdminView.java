/*
 * Created by JFormDesigner on Mon Dec 21 13:00:18 CET 2020
 */

package UIClasses;

import Model.AdminTable;
import Model.Doctor;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AdminView extends JPanel {
    private Controller controller;
    private AdminTable admin;
    private ArrayList<Doctor> docList;

    public AdminView(Controller controller, AdminTable admin, ArrayList<Doctor> docList) {
        this.controller = controller;
        this.admin = admin;
        this.docList = docList;
        initComponents();
        updateComponents(docList);
    }

    private void updateComponents(ArrayList<Doctor> docList) {
        DefaultComboBoxModel<Doctor> model = new DefaultComboBoxModel<>();

        for (Doctor doc : docList) {
            model.addElement(doc);
        }
        doctorListBox.setModel(model);
    }

    private void addDoctor(ActionEvent e) {
        int employeeNumber = Integer.parseInt(addDoctorField.getText());
        addDoctorField.setText("");

        String firstName = firstnameField.getText();
        firstnameField.setText("");

        String lastName = surnameField.getText();
        surnameField.setText("");

        String password = doctorPasswordField.getText();
        doctorPasswordField.setText("");

        String spec = addSpecField.getText();
        addSpecField.setText("");

        int visitCost = Integer.parseInt(addCostField.getText());
        addCostField.setText("");

        Doctor doctor = new Doctor(employeeNumber, firstName, lastName, spec, visitCost, password);

        controller.addDoctor(doctor);

        doctorListBox.addItem(doctor);
    }

    private void deleteDoctor(ActionEvent e) {
        Doctor doctor = (Doctor) doctorListBox.getSelectedItem();

        if (doctor != null) {
            doctorListBox.removeItem(doctor);
            controller.deleteDoctor(doctor);
        }
    }

    private void seeAppList(ActionEvent e) {
        if (appPatientList.getModel().getSize() != 0)
            appPatientList.removeAll();

        ArrayList<String> appList = controller.getAllAppointments();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (String app : appList) {
            model.addElement(app);
        }
        appPatientList.setModel(model);
    }


    private void seePatientList(ActionEvent e) {
        if (appPatientList.getModel().getSize() != 0)
            appPatientList.removeAll();

        ArrayList<String> patList = controller.getAllPatients(false);
        DefaultListModel<String> model = new DefaultListModel<>();

        for (String pat : patList) {
            model.addElement(pat);
        }

        appPatientList.setModel(model);

    }

    private void seeMedicalRecord(ActionEvent e) {
        int patientID = Integer.parseInt(patientIdField.getText());
        controller.openView("medical record", null, patientID, null);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Patrick Andersson
        addCostField = new JTextField();
        addSpecField = new JTextField();
        addDoctorField = new JTextField();
        firstnameField = new JTextField();
        surnameField = new JTextField();
        doctorPasswordField = new JTextField();
        doctorListBox = new JComboBox();
        deleteDoctorBtn = new JButton();
        addDoctorBtn = new JButton();
        addSpecLabel = new JLabel();
        employeeLabel = new JLabel();
        firstnameLabel = new JLabel();
        lastnameLabel = new JLabel();
        removeDoctorLabel = new JLabel();
        passwordLabel = new JLabel();
        patientListBtn = new JButton();
        appListBtn = new JButton();
        patientIdField = new JTextField();
        medRecBtn = new JButton();
        idLabel = new JLabel();
        listLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        appPatientList = new JList();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- deleteDoctorBtn ----
        deleteDoctorBtn.setText("Remove Doctor");
        deleteDoctorBtn.addActionListener(e -> deleteDoctor(e));

        //---- addDoctorBtn ----
        addDoctorBtn.setText("Add Doctor");
        addDoctorBtn.addActionListener(e -> addDoctor(e));

        //---- addSpecLabel ----
        addSpecLabel.setText("Add specialisation / add visit Price");

        //---- employeeLabel ----
        employeeLabel.setText("Employee number");

        //---- firstnameLabel ----
        firstnameLabel.setText("First name");

        //---- lastnameLabel ----
        lastnameLabel.setText("Last name");

        //---- removeDoctorLabel ----
        removeDoctorLabel.setText("Remove existing doctor");

        //---- passwordLabel ----
        passwordLabel.setText("Password - 8 digits");

        //---- patientListBtn ----
        patientListBtn.setText("Patient list");
        patientListBtn.addActionListener(e -> seePatientList(e));

        //---- appListBtn ----
        appListBtn.setText("Appointment list");
        appListBtn.addActionListener(e -> seeAppList(e));

        //---- medRecBtn ----
        medRecBtn.setText("See Medical Record");
        medRecBtn.addActionListener(e -> seeMedicalRecord(e));

        //---- idLabel ----
        idLabel.setText("Patient ID");

        //---- listLabel ----
        listLabel.setText("List and information of all patients and appointments");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(appPatientList);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(employeeLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(addSpecLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(idLabel))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(doctorPasswordField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(addDoctorBtn))
                                                .addComponent(passwordLabel)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(deleteDoctorBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                    .addComponent(doctorListBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(removeDoctorLabel)))
                                            .addGap(49, 49, 49)
                                            .addGroup(layout.createParallelGroup()
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(appListBtn)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(patientListBtn))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(17, 17, 17)
                                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 35, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(addDoctorField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstnameLabel))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lastnameLabel)
                                            .addGap(0, 386, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(addSpecField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(addCostField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                            .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(medRecBtn)))))
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(listLabel)
                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addSpecLabel)
                        .addComponent(employeeLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addCostField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addSpecField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(medRecBtn)
                        .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addDoctorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(listLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(appListBtn)
                                .addComponent(patientListBtn)))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordLabel)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(doctorPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(addDoctorBtn))
                            .addGap(43, 43, 43)
                            .addComponent(removeDoctorLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteDoctorBtn))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                    .addGap(97, 97, 97))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
    private JTextField addCostField;
    private JTextField addSpecField;
    private JTextField addDoctorField;
    private JTextField firstnameField;
    private JTextField surnameField;
    private JTextField doctorPasswordField;
    private JComboBox doctorListBox;
    private JButton deleteDoctorBtn;
    private JButton addDoctorBtn;
    private JLabel addSpecLabel;
    private JLabel employeeLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel removeDoctorLabel;
    private JLabel passwordLabel;
    private JButton patientListBtn;
    private JButton appListBtn;
    private JTextField patientIdField;
    private JButton medRecBtn;
    private JLabel idLabel;
    private JLabel listLabel;
    private JScrollPane scrollPane1;
    private JList appPatientList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
