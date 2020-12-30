/*
 * Created by JFormDesigner on Mon Dec 21 13:00:18 CET 2020
 */

package UIClasses;

import Model.AdminTable;
import Model.Doctor;
import Model.Spec_list;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminView extends JPanel {
    private Controller controller;
    private AdminTable admin;

    public AdminView(Controller controller, AdminTable admin) {
        this.controller = controller;
        this.admin = admin;
        initComponents();
    }

    private void addSpecialisation(ActionEvent e) {
        String spec = addSpecField.getText();
        addSpecField.setText("");

        int cost = Integer.parseInt(addCostField.getText());
        addCostField.setText("");

        Spec_list specialisation = new Spec_list(spec, cost);

        //DatabaseConnection.addSpecialisation(specialisation);
    }

    private void addDoctor(ActionEvent e) {
        int employeeNumber = Integer.parseInt(addDoctorField.getText());
        addDoctorField.setText("");

        String spec = chooseSpecBox.getSelectedItem().toString();

        String firstName = firstnameField.getText();
        firstnameField.setText("");

        String lastName = surnameField.getText();
        surnameField.setText("");

        String password = doctorPasswordField.getText();
        doctorPasswordField.setText("");

        Doctor doctor = new Doctor(employeeNumber, firstName, lastName, spec, password);

        //DatabaseConnection.addDoctor(doctor);
    }

    private void deleteDoctor(ActionEvent e) {
        Doctor doctor = (Doctor) doctorListBox.getSelectedItem();

        // if (doctor != null)
        // DatabaseConnection.deleteDoctor(doctor.getId());
    }

    private void seeAppList(ActionEvent e) {
        //TODO: add list function
    }

    private void seePatientList(ActionEvent e) {
        //TODO: add list function
    }

    private void seeMedicalRecord(ActionEvent e) {
        //TODO: add popup
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        addSpecField = new JTextField();
        addCostField = new JTextField();
        addDoctorField = new JTextField();
        chooseSpecBox = new JComboBox();
        firstnameField = new JTextField();
        surnameField = new JTextField();
        doctorPasswordField = new JTextField();
        doctorListBox = new JComboBox();
        deleteDoctorBtn = new JButton();
        addSpecBtn = new JButton();
        addDoctorBtn = new JButton();
        addSpecLabel = new JLabel();
        employeeLabel = new JLabel();
        specLabel = new JLabel();
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
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException()
                        ;
            }
        });

        //---- deleteDoctorBtn ----
        deleteDoctorBtn.setText("Remove Doctor");
        deleteDoctorBtn.addActionListener(e -> deleteDoctor(e));

        //---- addSpecBtn ----
        addSpecBtn.setText("Add Specialisation");
        addSpecBtn.addActionListener(e -> addSpecialisation(e));

        //---- addDoctorBtn ----
        addDoctorBtn.setText("Add Doctor");
        addDoctorBtn.addActionListener(e -> addDoctor(e));

        //---- addSpecLabel ----
        addSpecLabel.setText("Add specialisation / add visit Price");

        //---- employeeLabel ----
        employeeLabel.setText("Employee number");

        //---- specLabel ----
        specLabel.setText("Specialisation");

        //---- firstnameLabel ----
        firstnameLabel.setText("First name");

        //---- lastnameLabel ----
        lastnameLabel.setText("Last name");

        //---- removeDoctorLabel ----
        removeDoctorLabel.setText("Remove existing doctor");

        //---- passwordLabel ----
        passwordLabel.setText("Password - 6 digits");

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
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(addCostField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(addSpecField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(addSpecLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(79, 79, 79)
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(medRecBtn))
                                                                        .addComponent(idLabel)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(129, 129, 129)
                                                                                .addGroup(layout.createParallelGroup()
                                                                                        .addComponent(chooseSpecBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(lastnameLabel)
                                                                                        .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(doctorPasswordField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(addDoctorBtn))
                                                                        .addComponent(removeDoctorLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(deleteDoctorBtn, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup()
                                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(addDoctorField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                                                                                .addComponent(employeeLabel, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                                                                        .addComponent(firstnameLabel)
                                                                                        .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(passwordLabel))
                                                                                .addGap(27, 27, 27)
                                                                                .addComponent(specLabel)))
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(appListBtn)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(patientListBtn))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(17, 17, 17)
                                                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addSpecBtn)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(listLabel)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(addSpecLabel)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addCostField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addSpecField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addSpecBtn)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(employeeLabel)
                                                        .addComponent(specLabel))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addDoctorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(chooseSpecBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(medRecBtn)
                                                        .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23)
                                                .addComponent(listLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(appListBtn)
                                                        .addComponent(patientListBtn))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstnameLabel)
                                                        .addComponent(lastnameLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(passwordLabel)
                                                .addGap(3, 3, 3)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(doctorPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addDoctorBtn))
                                                .addGap(18, 18, 18)
                                                .addComponent(removeDoctorLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deleteDoctorBtn)))
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField addSpecField;
    private JTextField addCostField;
    private JTextField addDoctorField;
    private JComboBox chooseSpecBox;
    private JTextField firstnameField;
    private JTextField surnameField;
    private JTextField doctorPasswordField;
    private JComboBox doctorListBox;
    private JButton deleteDoctorBtn;
    private JButton addSpecBtn;
    private JButton addDoctorBtn;
    private JLabel addSpecLabel;
    private JLabel employeeLabel;
    private JLabel specLabel;
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
