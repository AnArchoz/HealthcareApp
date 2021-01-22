/*
 * Created by JFormDesigner on Mon Dec 21 12:31:15 CET 2020
 */

package UIClasses;

import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class WelcomeView extends JPanel {
    private Controller controller;

    public WelcomeView(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void login(ActionEvent e) {
        controller.openView("login", null);
    }

    private void signup(ActionEvent e) {
        controller.openView("signup", null);
    }

    private void signupBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        loginBTN = new JButton();
        signupBTN = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- loginBTN ----
        loginBTN.setText("LOGIN");
        loginBTN.addActionListener(e -> login(e));

        //---- signupBTN ----
        signupBTN.setText("SIGN UP");
        signupBTN.addActionListener(e -> {
			signupBTNActionPerformed(e);
			signup(e);
		});

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(signupBTN)
                    .addGap(57, 57, 57)
                    .addComponent(loginBTN)
                    .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(signupBTN)
                        .addComponent(loginBTN))
                    .addGap(73, 73, 73))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton loginBTN;
    private JButton signupBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
