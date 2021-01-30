package Model;


import java.sql.Timestamp;

public class Appointment {
    private int appId;
    private int patientId;
    private int doctorId;
    private String appDate;
    private Timestamp bookTime;

    @Override
    public String toString() {
        if (patientId == 0)
            return "Vacation day at: " + appDate;
        else
            return "Patient number: " + patientId + ", at: " + appDate;

    }

    public Appointment(int appId, Integer patientId, int doctorId, String appDate, Timestamp bookTime) {
        this.appId = appId;
        if (patientId == null)
            this.patientId = 0;
        else
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
