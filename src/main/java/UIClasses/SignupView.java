/*
 * Created by JFormDesigner on Mon Dec 21 12:37:10 CET 2020
 */

package UIClasses;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class SignupView extends JPanel {
    public SignupView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        usernameField = new JTextField();
        passwordField1 = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        signupBTN = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;

        //---- label1 ----
        label1.setText("USER SIGNUP");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.ITALIC, 25f));

        //---- usernameField ----
        usernameField.setToolTipText("Medical Number");

        //---- usernameLabel ----
        usernameLabel.setText("Medical number");

        //---- passwordLabel ----
        passwordLabel.setText("Passcode - 6 digits");

        //---- signupBTN ----
        signupBTN.setText("SIGN UP");

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
                                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
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
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField usernameField;
    private JPasswordField passwordField1;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton signupBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
