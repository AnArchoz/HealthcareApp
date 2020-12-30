package Model;

public class Spec_list {
    private String specialisation;
    private int doctorId;
    private int specPrice;

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(int specPrice) {
        this.specPrice = specPrice;
    }

    public Spec_list(String specialisation, int specPrice) {
        this.specialisation = specialisation;
        this.specPrice = specPrice;
    }
}
