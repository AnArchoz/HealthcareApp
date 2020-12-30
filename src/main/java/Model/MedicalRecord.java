package Model;

public class MedicalRecord {
    private int patientId;
    private int doctorId;
    private int mrAppId;
    private String appDate;
    private String diagnosis;
    private String description;
    private String drugs;

    public MedicalRecord(int patientId, int doctorId, int mrAppId, String appDate, String diagnosis, String description,
                         String drugs) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.mrAppId = mrAppId;
        this.appDate = appDate;
        this.diagnosis = diagnosis;
        this.description = description;
        this.drugs = drugs;
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

    public int getMrAppId() {
        return mrAppId;
    }

    public void setMrAppId(int mrAppId) {
        this.mrAppId = mrAppId;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }
}
