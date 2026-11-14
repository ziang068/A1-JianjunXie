import java.util.ArrayList;

public class Dietitian extends HealthProfessional {
    private String qualification;

    public Dietitian(int id, String name, ArrayList<String> availableDays, String qualification) {
        super(id, name, availableDays);
        this.qualification = qualification;
    }
    public Dietitian(int id, String name, String qualification) {
        super(id, name);
        this.qualification = qualification;
    }
    public String getQualification() { return qualification; }

    @Override
    public String toString() {
        return "[DIETITIAN] " + super.toString()
                + String.format(" | Qualification: %s", qualification);
    }
}