/*
 * Created by JFormDesigner on Mon Dec 21 13:20:11 CET 2020
 */

package UIClasses;

import Model.Appointment;
import Model.Doctor;
import com.sqlsamples.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class DoctorView extends JPanel {
    private ArrayList<Appointment> appList;
    private Controller controller;
    private Doctor doctor;
    private String[] days = {
            "mon",
            "tue",
            "wed",
            "thu",
            "fri",
    };
    private String[] times = {
            "09:00",
            "09:30",
            "10:00",
            "10.30",
    };

    public DoctorView(Controller controller, Doctor doctor, ArrayList<String> patientList) {
        this.controller = controller;
        this.doctor = doctor;
        appList = controller.getAppointments(doctor.getId());
        initComponents();
        updateComponents(patientList);
    }

    private void updateComponents(ArrayList<String> patientList) {
        DefaultComboBoxModel<String> patientModel = new DefaultComboBoxModel<>();
        ArrayList<String> uniquePatients = new ArrayList<>();
        for (String patient : patientList) {
            if (!uniquePatients.contains(patient))
                uniquePatients.add(patient);
        }

        for (String patient : uniquePatients) {
            patientModel.addElement(patient);
        }

        DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>();
        for (String day : days) {
            dayModel.addElement(day);
        }

        DefaultComboBoxModel<String> timeModel = new DefaultComboBoxModel<>();
        for (String time : times) {
            timeModel.addElement(time);
        }

        DefaultListModel<Appointment> bookingModel = new DefaultListModel<>();
        DefaultListModel<Appointment> vacationModel = new DefaultListModel<>();

        for (Appointment app : appList) {
            if (app.getPatientId() == 0)
                vacationModel.addElement(app);
            else {
                bookingModel.addElement(app);
            }
        }

        patientListBox.setModel(patientModel);
        weekdayBox.setModel(dayModel);
        timeBox.setModel(timeModel);
        bookingsList.setModel(bookingModel);
        vacationList.setModel(vacationModel);


    }

    private void makeDateUnavailable(ActionEvent e) {
        String weekday = weekdayBox.getSelectedItem().toString();
        String time = timeBox.getSelectedItem().toString();
    }

    private void addMedicalRecord(ActionEvent e) {
        int patientID = 0;
        if (patientListBox.getSelectedItem() != null)
            patientID = Integer.parseInt(patientListBox.getSelectedItem().toString());

        Appointment app = (Appointment) bookingsList.getSelectedValue();
        String bookDate = app.getAppDate();
        controller.openView("medical record", doctor, patientID, bookDate);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Patrick Andersson
        weekdayBox = new JComboBox();
        timeBox = new JComboBox();
        unavailableBtn = new JButton();
        scrollPane1 = new JScrollPane();
        bookingsList = new JList();
        scrollPane2 = new JScrollPane();
        vacationList = new JList();
        patientBookingLabel = new JLabel();
        vacationLabel = new JLabel();
        weekdayLabel = new JLabel();
        timeLabel = new JLabel();
        patientListBox = new JComboBox();
        addMedicalRecord = new JButton();
        patientListLabel = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062order".equals(e.getPropertyName())) throw new RuntimeException()
                        ;
            }
        });

        //---- unavailableBtn ----
        unavailableBtn.setText("Make unavailable");
        unavailableBtn.addActionListener(e -> makeDateUnavailable(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(bookingsList);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(vacationList);
        }

        //---- patientBookingLabel ----
        patientBookingLabel.setText("Patient bookings");

        //---- vacationLabel ----
        vacationLabel.setText("Vacation days");

        //---- weekdayLabel ----
        weekdayLabel.setText("Weekday");

        //---- timeLabel ----
        timeLabel.setText("Time");

        //---- addMedicalRecord ----
        addMedicalRecord.setText("Edit Medical Record");
        addMedicalRecord.addActionListener(e -> addMedicalRecord(e));

        //---- patientListLabel ----
        patientListLabel.setText("Patient list");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(addMedicalRecord)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(patientBookingLabel))
                                                                .addGap(51, 51, 51)
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(vacationLabel)
                                                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(unavailableBtn, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(weekdayBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(timeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addComponent(weekdayLabel)
                                                                .addGap(47, 47, 47)
                                                                .addComponent(timeLabel)))
                                                .addGap(59, 59, 59)
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(patientListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(patientListLabel)
                                                                .addGap(14, 14, 14)))))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(weekdayLabel)
                                        .addComponent(patientListLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(weekdayBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(unavailableBtn)
                                        .addComponent(addMedicalRecord))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientBookingLabel)
                                        .addComponent(vacationLabel))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrick Andersson
    private JComboBox weekdayBox;
    private JComboBox timeBox;
    private JButton unavailableBtn;
    private JScrollPane scrollPane1;
    private JList bookingsList;
    private JScrollPane scrollPane2;
    private JList vacationList;
    private JLabel patientBookingLabel;
    private JLabel vacationLabel;
    private JLabel weekdayLabel;
    private JLabel timeLabel;
    private JComboBox patientListBox;
    private JButton addMedicalRecord;
    private JLabel patientListLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
