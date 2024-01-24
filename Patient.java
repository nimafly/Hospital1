import java.util.*;
public class Patient extends Nurse {
    private long id;
    private String firstName;
    private String lastName;
    private String doctor;
    private String diagnosis;
    private ArrayList<String> medicines;
    private String medicien;
    private String date;
    public Patient(String firstName , String lastName , long id , String doctor, String date , String diagnosis) {

        super(firstName,lastName,id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.date = date;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.medicines = new ArrayList<>();

    }
    @Override
    public String getFirstName() { return firstName; }
    @Override
    public void setFirstName(String firstName) { this.firstName = firstName; }
    @Override
    public String getLastName() { return lastName; }
    @Override
    public void setLastName(String lastName) { this.lastName = lastName; }
    @Override
    public long getId() { return id; }
    @Override
    public void setId(long id) { this.id = id; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date;}
    public ArrayList<String> getMedicines() { return medicines; }
    public void setMedicines(ArrayList<String> medicines) { this.medicines = medicines; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void addMedicine(String medicine) { medicines.add(medicine); }
    public void removeMedicine(String medicine) { medicines.remove(medicine); }
    public void setMedicien(String medicien) { this.medicien = medicien; }
    public String getMedicien() { return medicien; }
    public void updateMedicine(String oldMedicine , String newMedicine) {

        int index = medicines.indexOf(oldMedicine);
        if (index != -1) {

            medicines.set(index , newMedicine);

        }

    }

    @Override
    public String toString() {

        return "Patient ID: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nDoctor: " + doctor + "\nDate: " + date +"\nDiagnosis: " + diagnosis + "\nMedicines: " + medicines;

    }

}