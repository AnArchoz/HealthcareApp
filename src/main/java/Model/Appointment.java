package Model;

import java.security.Timestamp;
import java.sql.Date;

public class Appointment {
    private int appId;
    private int patientId;
    private int doctorId;
    private String appDate;
    private Date bookTime;

    @Override
    public String toString() {
        return "Appointment{" +
                "appId=" + appId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appDate='" + appDate + '\'' +
                ", bookTime=" + bookTime +
                '}';
    }

    public Appointment(int appId, int patientId, int doctorId, String appDate, Date bookTime) {
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

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
}
