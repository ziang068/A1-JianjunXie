import java.util.ArrayList;

public class Nurse extends HealthProfessional {
    private String certificateId;

    public Nurse(int id, String name, ArrayList<String> availableDays, String certificateId) {
        super(id, name, availableDays);
        this.certificateId = certificateId;
    }
    public Nurse(int id, String name, String certificateId) {
        super(id, name);
        this.certificateId = certificateId;
    }
    public String getCertificateId() { return certificateId; }

    public void takeBloodSample() {
        System.out.printf("Nurse %s is taking a blood sample.%n", getName());
    }

    @Override
    public String toString() {
        return "[NURSE] " + super.toString()
                + String.format(" | Certificate ID: %s", certificateId);
    }
}