import java.util.ArrayList;

public class GeneralPractitioner extends HealthProfessional {
    private String registrationNumber;

    public GeneralPractitioner(int id, String name, ArrayList<String> availableDays, String registrationNumber) {
        super(id, name, availableDays);
        this.registrationNumber = registrationNumber;
    }
    public GeneralPractitioner(int id, String name, String registrationNumber) {
        super(id, name);
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationNumber() { return registrationNumber; }

    @Override
    public String toString() {
        return "[GENERAL PRACTITIONER] " + super.toString()
                + String.format(" | Registration No: %s", registrationNumber);
    }
}
