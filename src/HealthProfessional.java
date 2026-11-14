import java.util.ArrayList;
import java.util.Objects;

/** Part1: Abstract base class for all health professionals. */
public abstract class HealthProfessional {
    private int id;
    private String name;
    private ArrayList<String> availableDays;

    public HealthProfessional(int id, String name, ArrayList<String> availableDays) {
        if (id <= 0) throw new IllegalArgumentException("ID must be a positive number.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty.");
        this.id = id;
        this.name = name;
        this.availableDays = (availableDays == null) ? new ArrayList<>() : new ArrayList<>(availableDays);
    }

    public HealthProfessional(int id, String name) {
        this(id, name, new ArrayList<>());
    }

    // getters only, no setters
    public int getId() { return id; }
    public String getName() { return name; }
    public ArrayList<String> getAvailableDays() { return new ArrayList<>(availableDays); }

    public void addAvailableDay(String day) {
        if (day != null && !day.isBlank() && !availableDays.contains(day)) availableDays.add(day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id == ((HealthProfessional) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Working days: %s", id, name, availableDays);
    }
}