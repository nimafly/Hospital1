import java.util.ArrayList;
public class Appointment extends HospitalManagementSystem {
    private long id;
    private long patientId;
    private long nurseId;
    private ArrayList<Appointment> appointments;
    private String date;
    private String time;
    public Appointment(long id , long patientId , long nurseId , String date , String time) {

        this.id = id;
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.date = date;
        this.time = time;
        this.appointments = new ArrayList<>();

    }

    public long getId() { return id; }
    public long getPatientId() { return patientId; }
    public long getNurseId() { return nurseId; }
    public String getDate() { return date; }
    public String getTime() { return time; }

    public ArrayList<Appointment> getAppointments() { return appointments; }

    @Override
    public String toString() {

        return "Appointment ID: " + id + " , Patient ID: " + patientId + " , Nurse ID: " + nurseId + " , date: " + date + " , time: " + time;

    }

}