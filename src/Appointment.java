import java.util.ArrayList;
import java.util.List;

/** Part4: same-day appointment; sorted by time slot via Comparable. */
public class Appointment implements Comparable<Appointment> {

    /** Clinic hours 08:00-16:00, 30-minute intervals. */
    public static final List<String> CLINIC_SLOTS = buildSlots();

    private static List<String> buildSlots() {
        ArrayList<String> slots = new ArrayList<>();
        for (int m = 8 * 60; m <= 16 * 60; m += 30) {
            slots.add(String.format("%02d:%02d", m / 60, m % 60));
        }
        return slots;
    }

    private final String patientName;
    private final String patientMobile;
    private final HealthProfessional healthProfessional;
    private final String timeSlot;

    public Appointment(String patientName, String patientMobile,
                       HealthProfessional healthProfessional, String timeSlot) {
        if (patientName == null || patientName.isBlank())
            throw new IllegalArgumentException("Patient name cannot be empty.");
        if (patientMobile == null || !patientMobile.matches("\\d{8,15}"))
            throw new IllegalArgumentException("Patient mobile must be 8-15 digits.");
        if (healthProfessional == null)
            throw new IllegalArgumentException("Health professional cannot be null.");
        if (!isValidTimeSlot(timeSlot))
            throw new IllegalArgumentException("Invalid time slot: " + timeSlot);

        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.healthProfessional = healthProfessional;
        this.timeSlot = timeSlot;
    }

    public static boolean isValidTimeSlot(String slot) {
        return slot != null && CLINIC_SLOTS.contains(slot);
    }

    public String getPatientName() { return patientName; }
    public String getPatientMobile() { return patientMobile; }
    public HealthProfessional getHealthProfessional() { return healthProfessional; }
    public String getTimeSlot() { return timeSlot; }

    @Override
    public int compareTo(Appointment other) {
        int a = CLINIC_SLOTS.indexOf(this.timeSlot);
        int b = CLINIC_SLOTS.indexOf(other.timeSlot);
        if (a != b) return Integer.compare(a, b);
        return Integer.compare(this.healthProfessional.getId(), other.healthProfessional.getId());
    }

    @Override
    public String toString() {
        return String.format("Appointment -> Patient: %s (%s) | Slot: %s%n              With: %s",
                patientName, patientMobile, timeSlot, healthProfessional);
    }
}