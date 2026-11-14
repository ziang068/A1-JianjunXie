import java.util.ArrayList;
import java.util.Collections;

/** Part5: add / filter / sort / cancel appointments. */
public class AppointmentManager {

    private final ArrayList<Appointment> appointments = new ArrayList<>();

    public ArrayList<Appointment> getAllAppointments() { return new ArrayList<>(appointments); }

    public String addAppointment(Appointment appointment) {
        if (appointment == null) return "WARNING: appointment is null.";
        if (!Appointment.isValidTimeSlot(appointment.getTimeSlot()))
            return "WARNING: invalid slot " + appointment.getTimeSlot() + " (08:00-16:00, 30 min).";
        for (Appointment e : appointments) {
            if (e.getHealthProfessional().getId() == appointment.getHealthProfessional().getId()
                    && e.getTimeSlot().equals(appointment.getTimeSlot())) {
                return "WARNING: " + e.getHealthProfessional().getName()
                        + " is already booked at " + e.getTimeSlot() + ".";
            }
        }
        appointments.add(appointment);
        return "SUCCESS: added " + appointment.getPatientName() + " at " + appointment.getTimeSlot() + ".";
    }

    public ArrayList<Appointment> findAppointmentsByProfessionalId(int professionalId) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments)
            if (a.getHealthProfessional().getId() == professionalId) result.add(a);
        return result;
    }

    public ArrayList<Appointment> findAppointmentsByPatientMobile(String mobile) {
        ArrayList<Appointment> result = new ArrayList<>();
        if (mobile == null) return result;
        for (Appointment a : appointments)
            if (a.getPatientMobile().equals(mobile)) result.add(a);
        return result;
    }

    public ArrayList<Appointment> sortByTimeSlot(ArrayList<Appointment> list) {
        ArrayList<Appointment> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    /** Overload 1: cancel by professional ID + time slot. */
    public String cancelAppointment(int professionalId, String timeSlot) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getHealthProfessional().getId() == professionalId && a.getTimeSlot().equals(timeSlot)) {
                appointments.remove(i);
                return "SUCCESS: cancelled " + a.getPatientName() + " with "
                        + a.getHealthProfessional().getName() + " at " + timeSlot + ".";
            }
        }
        return "WARNING: no appointment for professional " + professionalId + " at " + timeSlot + ".";
    }

    /** Overload 2: cancel by patient mobile. */
    public String cancelAppointment(String patientMobile) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getPatientMobile().equals(patientMobile)) {
                appointments.remove(i);
                return "SUCCESS: cancelled " + a.getPatientName() + " at " + a.getTimeSlot() + ".";
            }
        }
        return "WARNING: no appointment for patient mobile " + patientMobile + ".";
    }

    public void printAllAppointments() { printAppointments(appointments); }

    public void printAppointments(ArrayList<Appointment> list) {
        if (list.isEmpty()) { System.out.println("  (no appointments)"); return; }
        for (Appointment a : list) System.out.println("  " + a);
    }
}