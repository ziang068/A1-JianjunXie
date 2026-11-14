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

        HealthProfessional gp1 = new GeneralPractitioner(2001, "Dr Wei Zhang", monWedFri, "REG-2401");
        HealthProfessional gp2 = new GeneralPractitioner(2002, "Dr Li Chen", tueThu, "REG-2402");
        HealthProfessional gp3 = new GeneralPractitioner(2003, "Dr Hao Wang", monWedFri, "REG-2403");
        HealthProfessional nurse1 = new Nurse(2010, "Nurse Xu Fang", monWedFri, "NUR-1082");
        HealthProfessional surgeon1 = new Surgeon(3001, "Dr Yang Liu", tueThu, "Orthopaedic Surgery");
        HealthProfessional dietitian1 = new Dietitian(4001, "Ms Song Mei", monWedFri, "Bachelor of Nutrition");

        ArrayList<HealthProfessional> professionals = new ArrayList<>();
        professionals.add(gp1); professionals.add(gp2); professionals.add(gp3);
        professionals.add(nurse1); professionals.add(surgeon1); professionals.add(dietitian1);

        for (HealthProfessional hp : professionals) {
            System.out.println(hp);
            System.out.println("----------------------------------------------------");
        }

        // ---------- Part 6 ----------
        System.out.println("\n========== PART 6: APPOINTMENT SYSTEM DEMO ==========");
        AppointmentManager manager = new AppointmentManager();

        System.out.println("\n--- 6.1 Adding valid appointments ---");
        System.out.println(manager.addAppointment(new Appointment("Liu Wei", "13512340001", gp1, "09:00")));
        System.out.println(manager.addAppointment(new Appointment("Chen Jing", "13512340002", gp2, "10:30")));
        System.out.println(manager.addAppointment(new Appointment("Zhao Min", "13512340003", gp1, "13:00")));
        System.out.println(manager.addAppointment(new Appointment("Sun Qi", "13512340004", nurse1, "08:30")));
        System.out.println(manager.addAppointment(new Appointment("Wu Tao", "13512340005", surgeon1, "15:30")));
        System.out.println(manager.addAppointment(new Appointment("Qian Li", "13512340006", dietitian1, "11:00")));

        System.out.println("\n--- 6.2 Invalid attempts (error handling) ---");
        System.out.println(manager.addAppointment(
                new Appointment("Zhou Qiang", "13512340007", gp1, "09:00")));
        try {
            System.out.println(manager.addAppointment(
                    new Appointment("Zhou Qiang", "13512340007", gp1, "09:15")));
        } catch (IllegalArgumentException e) {
            System.out.println("WARNING: " + e.getMessage());
        }
        try {
            new Appointment("Bad Mobile", "abc", gp2, "12:00");
        } catch (IllegalArgumentException e) {
            System.out.println("WARNING: " + e.getMessage());
        }

        System.out.println("\n--- 6.3 All appointments ---");
        manager.printAllAppointments();

        System.out.println("\n--- 6.4 Filter by professional ID 2001 ---");
        manager.printAppointments(manager.findAppointmentsByProfessionalId(2001));

        System.out.println("\n--- 6.5 Filter by patient mobile 13512340004 ---");
        manager.printAppointments(manager.findAppointmentsByPatientMobile("13512340004"));

        System.out.println("\n--- 6.6 Sorted by time slot ---");
        manager.printAppointments(manager.sortByTimeSlot(manager.getAllAppointments()));

        System.out.println("\n--- 6.7 Cancel by professional ID + slot ---");
        System.out.println(manager.cancelAppointment(2001, "13:00"));

        System.out.println("\n--- 6.8 Cancel by patient mobile ---");
        System.out.println(manager.cancelAppointment("13512340005"));

        System.out.println("\n--- 6.9 Cancel failures ---");
        System.out.println(manager.cancelAppointment(9999, "09:30"));
        System.out.println(manager.cancelAppointment("13900000000"));

        System.out.println("\n--- 6.10 Remaining appointments ---");
        manager.printAllAppointments();

        System.out.println("\n========== END OF DEMONSTRATION ==========");
    }
}