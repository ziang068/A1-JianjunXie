import java.util.ArrayList;

public class Surgeon extends HealthProfessional {
    private String surgicalSpecialty;

    public Surgeon(int id, String name, ArrayList<String> availableDays, String surgicalSpecialty) {
        super(id, name, availableDays);
        this.surgicalSpecialty = surgicalSpecialty;
    }
    public Surgeon(int id, String name, String surgicalSpecialty) {
        super(id, name);
        this.surgicalSpecialty = surgicalSpecialty;
    }
    public String getSurgicalSpecialty() { return surgicalSpecialty; }

    @Override
    public String toString() {
        return "[SURGEON] " + super.toString()
                + String.format(" | Specialty: %s", surgicalSpecialty);
    }
}