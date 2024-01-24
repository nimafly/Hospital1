import java.util.ArrayList;
public class Nurse extends HospitalManagementSystem {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Nurse> nurses;
    public Nurse(String firstName , String lastName , String password , long id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.id = id;

    }
    public Nurse(String firstName, String lastName, long id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = this.id;

    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    @Override
    public String toString() {

        return "Nurse ID: " + id + "\nFist name: " + firstName + "\nLast name: " + lastName + "\nPassword: " + password;

    }

    public void add(Nurse nurse) { nurses.add(nurse); }

}