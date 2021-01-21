/*
 * Created by JFormDesigner on Mon Dec 21 12:49:29 CET 2020
 */

package UIClasses;

import Model.AdminTable;
import Model.Doctor;
import Model.Patient;
import com.sqlsamples.Controller;
import com.sqlsamples.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class LoginView extends JPanel {
    private Controller controller;

    public LoginView(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void login(ActionEvent e) {
        int username = Integer.parseInt(usernameField.getText());
        String password = new String(passwordField.getPassword());


        if (patientRadioBtn.isSelected()) {
            Patient patient = DatabaseConnection.checkPatientLogin(username, password);
            if (patient != null) {
                controller.openView("patient", patient);
            }
        } else if (doctorRadioBtn.isSelected()) {
            Doctor doctor = DatabaseConnection.checkDoctorLogin(username, password);
            if (doctor != null) {
                controller.openView("doctor", doctor);
            }
        } else if (adminRadioBtn.isSelected()) {
            AdminTable admin = DatabaseConnection.checkAdminLogin(username, password);

            if (admin != null) {
                controller.openView("admin", admin);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Patrick Andersson
        adminRadioBtn = new JRadioButton();
        patientRadioBtn = new JRadioButton();
        doctorRadioBtn = new JRadioButton();
        loginLabel = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
        EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing
        .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),
        java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))
        throw new RuntimeException();}});

        //---- adminRadioBtn ----
        adminRadioBtn.setText("Admin");

        //---- patientRadioBtn ----
        patientRadioBtn.setText("Patient");

        //---- doctorRadioBtn ----
        doctorRadioBtn.setText("Doctor");

        //---- loginLabel ----
        loginLabel.setText("Log in as:");

        //---- usernameField ----
        usernameField.setToolTipText("Password LMAO");

        //---- usernameLabel ----
        usernameLabel.setText("ID/Username/MedID");

        //---- passwordLabel ----
        passwordLabel.setText("Passcode/Password - 8 digits");

        //---- loginBtn ----
        loginBtn.setText("LOG IN");
        loginBtn.addActionListener(e -> login(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(doctorRadioBtn)
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientRadioBtn))
                    .addGap(18, 18, 18)
                    .addComponent(adminRadioBtn)
                    .addGap(99, 99, 99))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(loginBtn)))
                    .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(adminRadioBtn)
                        .addComponent(patientRadioBtn)
                        .addComponent(doctorRadioBtn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(usernameLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(loginBtn)
                    .addContainerGap(29, Short.MAX_VALUE))
        );

        //---- radioBtnGroup ----
        ButtonGroup radioBtnGroup = new ButtonGroup();
        radioBtnGroup.add(adminRadioBtn);
        radioBtnGroup.add(patientRadioBtn);
        radioBtnGroup.add(doctorRadioBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
    private JRadioButton adminRadioBtn;
    private JRadioButton patientRadioBtn;
    private JRadioButton doctorRadioBtn;
    private JLabel loginLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
