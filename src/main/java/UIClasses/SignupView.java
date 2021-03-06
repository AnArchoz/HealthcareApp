/*
 * Created by JFormDesigner on Mon Dec 21 12:37:10 CET 2020
 */

package UIClasses;

import Model.Patient;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author unknown
 */
public class SignupView extends JPanel {
    private Controller controller;

    public SignupView(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void signup(ActionEvent e) {
        int username = Integer.parseInt(usernameField.getText());
        String password = new String(passwordField1.getPassword());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Patient patient = new Patient(username, "", "", "", "",
                0, new Date(0), timestamp, password, 0);
        controller.addPatient(patient);
        controller.openView("patient", patient, username, null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Patrick Andersson
        label1 = new JLabel();
        usernameField = new JTextField();
        passwordField1 = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        signupBTN = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("USER SIGNUP");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.ITALIC, 25f));

        //---- usernameField ----
        usernameField.setToolTipText("Medical Number");

        //---- usernameLabel ----
        usernameLabel.setText("Medical number - 9 digits");

        //---- passwordLabel ----
        passwordLabel.setText("Passcode - 8 digits");

        //---- signupBTN ----
        signupBTN.setText("SIGN UP");
        signupBTN.addActionListener(e -> signup(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(signupBTN))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameField)
                                .addComponent(passwordField1)
                                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usernameLabel)
                    .addGap(2, 2, 2)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)
                    .addComponent(passwordLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(signupBTN)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
    private JLabel label1;
    private JTextField usernameField;
    private JPasswordField passwordField1;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton signupBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
