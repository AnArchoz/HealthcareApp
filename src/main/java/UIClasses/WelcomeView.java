/*
 * Created by JFormDesigner on Mon Dec 21 12:31:15 CET 2020
 */

package UIClasses;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class WelcomeView extends JPanel {
    public WelcomeView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        LoginBTN = new JButton();
        signupBTN = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- LoginBTN ----
        LoginBTN.setText("LOGIN");

        //---- signupBTN ----
        signupBTN.setText("SIGN UP");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(signupBTN)
                    .addGap(57, 57, 57)
                    .addComponent(LoginBTN)
                    .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(signupBTN)
                        .addComponent(LoginBTN))
                    .addGap(73, 73, 73))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton LoginBTN;
    private JButton signupBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
