/*
 * Created by JFormDesigner on Mon Dec 21 12:49:29 CET 2020
 */

package UIClasses;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class LoginView extends JPanel {
    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        adminRadioBtn = new JRadioButton();
        patientRadioBtn = new JRadioButton();
        doctorRadioBtn = new JRadioButton();
        loginLabel = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

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
        usernameLabel.setText("ID/Username - 6 digits");

        //---- passwordLabel ----
        passwordLabel.setText("Passcode/Password - 6 digits");

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
                    .addGap(127, 127, 127)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(passwordField, GroupLayout.Alignment.TRAILING)
                        .addComponent(passwordLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(usernameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addContainerGap(91, Short.MAX_VALUE))
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
                    .addGap(34, 34, 34)
                    .addComponent(usernameLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(passwordLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JRadioButton adminRadioBtn;
    private JRadioButton patientRadioBtn;
    private JRadioButton doctorRadioBtn;
    private JLabel loginLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
