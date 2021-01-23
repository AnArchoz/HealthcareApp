/*
 * Created by JFormDesigner on Mon Dec 21 17:51:42 CET 2020
 */

package UIClasses;

import Model.Doctor;
import Model.MedicalRecord;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class MedicalRecordView extends JPanel {
    private Controller controller;
    private MedicalRecord record;
    private Doctor doctor;

    public MedicalRecordView(Controller controller, MedicalRecord record, Doctor doctor) {
        this.controller = controller;
        this.record = record;
        this.doctor = doctor;
        initComponents(record);
    }

    private void saveRecord(ActionEvent e) {
        int patientId = Integer.parseInt(patNameLabel.getText());
        int doctorId = doctor.getId();
        int appId = 0;

        String appDate = dateLabel.getText();
        String diagnosis = diagField.getText();
        String description = descField.getText();
        String drugs = drugField.getText();

        MedicalRecord medicalRecord =
                new MedicalRecord(patientId, doctorId, appId, appDate,
                        diagnosis, description, drugs);

        controller.addMedicalRecord(medicalRecord);
    }

    private void initComponents(MedicalRecord record) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Antoine Rebelo

        scrollPane1 = new JScrollPane();
        diagField = new JTextPane();
        diagField.setText(record.getDiagnosis());
        diagLabel = new JLabel();
        scrollPane2 = new JScrollPane();
        descField = new JTextPane();
        descField.setText(record.getDescription());
        descLabel = new JLabel();
        patNameLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        drugField = new JTextPane();
        drugField.setText(record.getDrugs());
        drugLabel = new JLabel();
        dateLabel = new JLabel();
        saveRecordBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("Dialo\u0067", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("borde\u0072".equals(e.getPropertyName())) throw new RuntimeException()
                        ;
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(diagField);
        }

        //---- diagLabel ----
        diagLabel.setText("Diagnosis");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(descField);
        }

        //---- descLabel ----
        descLabel.setText("Description");

        //---- patNameLabel ----
        patNameLabel.setText("" + record.getPatientId());

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(drugField);
        }

        //---- drugLabel ----
        drugLabel.setText("Drugs");

        //---- dateLabel ----
        dateLabel.setText(record.getAppDate());

        //---- saveRecordBtn ----
        saveRecordBtn.setText("SAVE RECORD");
        saveRecordBtn.addActionListener(e -> saveRecord(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                                .addComponent(descLabel, GroupLayout.Alignment.LEADING)
                                                                .addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                                        .addComponent(diagLabel))
                                                .addGap(57, 57, 57)
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(drugLabel)
                                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(saveRecordBtn)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addComponent(patNameLabel)
                                                .addGap(43, 43, 43)
                                                .addComponent(dateLabel)))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(patNameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(descLabel)
                                        .addComponent(drugLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(diagLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(saveRecordBtn)))
                                .addGap(37, 37, 37))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
    private JScrollPane scrollPane1;
    private JTextPane diagField;
    private JLabel diagLabel;
    private JScrollPane scrollPane2;
    private JTextPane descField;
    private JLabel descLabel;
    private JLabel patNameLabel;
    private JScrollPane scrollPane3;
    private JTextPane drugField;
    private JLabel drugLabel;
    private JLabel dateLabel;
    private JButton saveRecordBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
