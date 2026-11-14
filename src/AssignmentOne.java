import java.util.ArrayList;

/** Entry point: Part3 professional list + Part6 full appointment demo. */
public class AssignmentOne {

    public static void main(String[] args) {
        // ---------- Part 3 ----------
        System.out.println("========== PART 3: ALL HEALTH PROFESSIONALS ==========");

        ArrayList<String> monWedFri = new ArrayList<>();
        monWedFri.add("MONDAY"); monWedFri.add("WEDNESDAY"); monWedFri.add("FRIDAY");
        ArrayList<String> tueThu = new ArrayList<>();
        tueThu.add("TUESDAY"); tueThu.add("THURSDAY");

        HealthProfessional gp1 = new GeneralPractitioner(101, "Dr Alice Smith", monWedFri, "GP-001");
        HealthProfessional gp2 = new GeneralPractitioner(102, "Dr Bob Brown", tueThu, "GP-002");
        HealthProfessional gp3 = new GeneralPractitioner(103, "Dr Charlie Lee", monWedFri, "GP-003");
        HealthProfessional nurse1 = new Nurse(201, "Nurse Emma Hall", monWedFri, "NUR-5678");
        HealthProfessional surgeon1 = new Surgeon(301, "Dr Frank Wilson", tueThu, "Cardiac Surgery");
        HealthProfessional dietitian1 = new Dietitian(401, "Ms Grace Moore", monWedFri, "Master of Nutrition");

        ArrayList<HealthProfessional> professionals = new ArrayList<>();
        professionals.add(gp1); professionals.add(gp2); professionals.add(gp3);
        professionals.add(nurse1); professionals.add(surgeon1); professionals.add(dietitian1);

        for (HealthProfessional hp : professionals) {   // polymorphism
            System.out.println(hp);
            System.out.println("----------------------------------------------------");
        }

        // ---------- Part 6 ----------
        System.out.println("\n========== PART 6: APPOINTMENT SYSTEM DEMO ==========");
        AppointmentManager manager = new AppointmentManager();

        System.out.println("\n--- 6.1 Adding valid appointments ---");
        System.out.println(manager.addAppointment(new Appointment("John Doe", "0412345678", gp1, "09:00")));
        System.out.println(manager.addAppointment(new Appointment("Mary Jane", "0423456789", gp2, "10:30")));
        System.out.println(manager.addAppointment(new Appointment("Peter Parker", "0434567890", gp1, "13:00")));
        System.out.println(manager.addAppointment(new Appointment("Lucy Liu", "0445678901", nurse1, "08:30")));
        System.out.println(manager.addAppointment(new Appointment("Sam Lee", "0456789012", surgeon1, "15:30")));
        System.out.println(manager.addAppointment(new Appointment("Anna Bell", "0467890123", dietitian1, "11:00")));

        System.out.println("\n--- 6.2 Invalid attempts ---");
        System.out.println(manager.addAppointment(new Appointment("Tom Hardy", "0478901234", gp1, "09:00")));
        System.out.println(manager.addAppointment(new Appointment("Tom Hardy", "0478901234", gp1, "09:15")));
        try {
            new Appointment("Bad Mobile", "abc", gp2, "12:00");
        } catch (IllegalArgumentException e) {
            System.out.println("WARNING: " + e.getMessage());
        }

        System.out.println("\n--- 6.3 All appointments ---");
        manager.printAllAppointments();

        System.out.println("\n--- 6.4 Filter by professional ID 101 ---");
        manager.printAppointments(manager.findAppointmentsByProfessionalId(101));

        System.out.println("\n--- 6.5 Filter by patient mobile 0445678901 ---");
        manager.printAppointments(manager.findAppointmentsByPatientMobile("0445678901"));

        System.out.println("\n--- 6.6 Sorted by time slot ---");
        manager.printAppointments(manager.sortByTimeSlot(manager.getAllAppointments()));

        System.out.println("\n--- 6.7 Cancel by professional ID + slot ---");
        System.out.println(manager.cancelAppointment(101, "13:00"));

        System.out.println("\n--- 6.8 Cancel by patient mobile ---");
        System.out.println(manager.cancelAppointment("0456789012"));

        System.out.println("\n--- 6.9 Cancel failures ---");
        System.out.println(manager.cancelAppointment(999, "09:00"));
        System.out.println(manager.cancelAppointment("0000000000"));

        System.out.println("\n--- 6.10 Remaining appointments ---");
        manager.printAllAppointments();

        System.out.println("\n========== END OF DEMONSTRATION ==========");
    }
}