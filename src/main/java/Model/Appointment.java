package Model;

import java.security.Timestamp;

public class Appointment {
    private int appId;
    private int patientId;
    private int doctorId;
    private String appDate;
    private Timestamp bookTime;

    public Appointment(int appId, int patientId, int doctorId, String appDate, Timestamp bookTime) {
        this.appId = appId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appDate = appDate;
        this.bookTime = bookTime;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public Timestamp getBookTime() {
        return bookTime;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }
}
