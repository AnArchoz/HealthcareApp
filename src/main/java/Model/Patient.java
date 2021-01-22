package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Patient {
    private int patientId;
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private int phone;
    private Date birthDate;
    private String regDay;
    private String password;
    private int totalCost;

    public Patient(int patientId, String firstname, String lastname, String gender, String address, int phone,
                   Date birthDate, String regDay, String password, int totalCost) {
        this.patientId = patientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.regDay = regDay;
        this.password = password;
        this.totalCost = totalCost;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", birthDate=" + birthDate +
                ", regDay='" + regDay + '\'' +
                ", password='" + password + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegDay() {
        return regDay;
    }

    public void setRegDay(String regDay) {
        this.regDay = regDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
