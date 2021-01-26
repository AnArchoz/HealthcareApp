package Model;

import java.util.Arrays;
import java.util.LinkedList;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String specialisation;
    private String pw;
    private int visitCost;
    private LinkedList<String> freeTimes = new LinkedList<>(
            Arrays.asList("50 09:00 mon", "50 09:30 mon", "50 10:00 mon", "50 10:30 mon",
                    "50 09:00 tue", "50 09:30 tue", "50 10:00 tue", "50 10:30 tue",
                    "50 09:00 wed", "50 09:30 wed", "50 10:00 wed", "50 10:30 wed",
                    "50 09:00 thu", "50 09:30 thu", "50 10:00 thu", "50 10:30 thu",
                    "50 09:00 fri", "50 09:30 fri", "50 10:00 fri", "50 10:30 fri"));


    public int getVisitCost() {
        return visitCost;
    }

    public void setVisitCost(int visitCost) {
        this.visitCost = visitCost;
    }

    public int getId() {
        return id;
    }

    public LinkedList<String> getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(LinkedList<String> freeTimes) {
        this.freeTimes = freeTimes;
    }

    public void book(String date) {
        freeTimes.remove(date);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", specialisation: " + specialisation + ", visit cost: " + visitCost;
    }

    public Doctor(int id, String firstName, String lastName, String specialisation, int visitCost, String pw) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialisation = specialisation;
        this.pw = pw;
        this.visitCost = visitCost;
    }
}
