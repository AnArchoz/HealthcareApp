/*
 * Created by JFormDesigner on Mon Dec 21 13:00:18 CET 2020
 */

package UIClasses;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AdminView extends JPanel {
    public AdminView() {
        initComponents();
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
        phoneNumberField = new JTextField();
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
        phoneNumberLabel = new JLabel();
        passwordLabel = new JLabel();
        patientListBtn = new JButton();
        appListBtn = new JButton();
        patientIdField = new JTextField();
        medRecBtn = new JButton();
        idLabel = new JLabel();
        listLabel = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- deleteDoctorBtn ----
        deleteDoctorBtn.setText("Remove Doctor");

        //---- addSpecBtn ----
        addSpecBtn.setText("Add Specialisation");

        //---- addDoctorBtn ----
        addDoctorBtn.setText("Add Doctor");

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

        //---- phoneNumberLabel ----
        phoneNumberLabel.setText("Phone number");

        //---- passwordLabel ----
        passwordLabel.setText("Password - 6 digits");

        //---- patientListBtn ----
        patientListBtn.setText("Patient list");

        //---- appListBtn ----
        appListBtn.setText("Appointment list");

        //---- medRecBtn ----
        medRecBtn.setText("See Medical Record");

        //---- idLabel ----
        idLabel.setText("Patient ID");

        //---- listLabel ----
        listLabel.setText("List and information of all patients and appointments");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstnameLabel))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lastnameLabel)
                                    .addContainerGap(426, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(surnameField)
                                    .addContainerGap(393, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(phoneNumberField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addComponent(phoneNumberLabel)
                                        .addComponent(addDoctorField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addComponent(employeeLabel, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(passwordLabel)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(doctorPasswordField, GroupLayout.Alignment.TRAILING)
                                                .addComponent(chooseSpecBox, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                                .addComponent(specLabel))
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(80, 80, 80)
                                                    .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(medRecBtn))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(9, 9, 9)
                                                            .addComponent(idLabel))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(patientListBtn)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(appListBtn))
                                                            .addComponent(listLabel, GroupLayout.Alignment.LEADING))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(addDoctorBtn)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(deleteDoctorBtn, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(44, 44, 44))))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 395, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(removeDoctorLabel))
                                    .addGap(44, 44, 44)))
                            .addGap(82, 82, 82))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(addSpecBtn)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addCostField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addSpecField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                .addComponent(addSpecLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(423, Short.MAX_VALUE))))
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
                            .addComponent(addSpecBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(listLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(patientListBtn)
                                .addComponent(appListBtn))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(employeeLabel)
                        .addComponent(idLabel)
                        .addComponent(specLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addDoctorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseSpecBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(medRecBtn))
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordLabel)
                                .addComponent(phoneNumberLabel)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(removeDoctorLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(doctorListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addDoctorBtn)
                        .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(doctorPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteDoctorBtn))
                    .addGap(10, 10, 10))
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
    private JTextField phoneNumberField;
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
    private JLabel phoneNumberLabel;
    private JLabel passwordLabel;
    private JButton patientListBtn;
    private JButton appListBtn;
    private JTextField patientIdField;
    private JButton medRecBtn;
    private JLabel idLabel;
    private JLabel listLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
