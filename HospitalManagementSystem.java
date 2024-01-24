import java.util.*;
import java.io.*;
public class HospitalManagementSystem extends Main {
    private final ArrayList<Nurse> nurses;
    private final ArrayList<Patient> patients;
    private final ArrayList<Appointment> appointments;
    private final Scanner input;
    public HospitalManagementSystem() {

        nurses = new ArrayList<Nurse>();
        patients = new ArrayList<Patient>();
        appointments = new ArrayList<Appointment>();
        input = new Scanner(System.in);

    }
    public void loadData(){

        try {

            File nursesFile = new File("nurses.txt");
            Scanner fileReader = new Scanner(nursesFile);

                while (fileReader.hasNextLine()) {

                    String line = fileReader.nextLine();

                    String[] tokens = line.split("\n");


                    String firstName = tokens[1];
                    String lastName = tokens[2];
                    long id = Long.parseLong(tokens[0]);
                    String password = tokens[3];

                    Nurse nurse = new Nurse(firstName , lastName , password , id);
                    nurses.add(nurse);

                }

                fileReader.close();

                File patientsFile = new File("PatientS.txt");
                fileReader = new Scanner(patientsFile);

                    while (fileReader.hasNextLine()) {

                        String line = fileReader.nextLine();

                        String[] tokens = line.split("\n");


                        String firstName = tokens[1];
                        String lastName = tokens[2];
                        String doctor = tokens[3];
                        long id = Long.parseLong(tokens[0]);
                        String date = tokens[4];
                        String diagnosis = tokens[5];

                        Patient patient = new Patient(firstName , lastName , id , doctor, date , diagnosis);

                        int numberOfMediciens = Integer.parseInt(tokens[6]);

                        for (int i = 0; i < numberOfMediciens; i++) {

                            String Medicien = tokens[ 7 + i ];
                            patient.addMedicine(Medicien);

                        }

                        patients.add(patient);

                    }

                    fileReader.close();

                    File appointmentsFile = new File("Appointments.txt");
                    fileReader = new Scanner(appointmentsFile);

                        while (fileReader.hasNextLine()) {

                            String line = fileReader.nextLine();

                            String[] tokens = line.split("\n");

                            long id = Long.parseLong(tokens[0]);
                            long patientId = Long.parseLong(tokens[1]);
                            long nurseId = Long.parseLong(tokens[2]);
                            String date = tokens[3];
                            String time = tokens[4];

                            Appointment appointment = new Appointment(id , patientId , nurseId , date , time);
                            appointments.add(appointment);

                        }

                        fileReader.close();

            System.out.println("Data loaded successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("An Error occurred while loading the data.");
            e.printStackTrace();

        }

    }
    public void savaData() {

        try{

            File nursesFile = new File("nurses.txt");
            PrintWriter fileWriter = new PrintWriter(nursesFile);

            for (Nurse nurse: nurses) {

                fileWriter.println("******************************");
                fileWriter.println("ID: " + nurse.getId() + "\nFirst Name: " + nurse.getFirstName() + "\nLast Name: " + nurse.getLastName() + "\nPassword: " + nurse.getPassword());

            }

            fileWriter.close();

            File patientsFile = new File("patients.txt");
            fileWriter = new PrintWriter(patientsFile);

            for (Patient patient : patients) {

                fileWriter.println("******************************");
                fileWriter.println("ID: " + patient.getId() + "\nFist Name: " + patient.getFirstName() + "\nLast Name: " + patient.getLastName() + "\nDoctor: " + patient.getDoctor() + "\nDate: " + patient.getDate() + "\nDiagnosis: " + patient.getDiagnosis() + "\nMedicines: " + patient.getMedicines());

            }

            fileWriter.close();

            File appointmentsFile = new File("appointments.txt");
            fileWriter = new PrintWriter(appointmentsFile);

            for (Appointment appointment: appointments) {

                fileWriter.println("******************************");
                fileWriter.println("ID: " + appointment.getId() + "\nPatient ID: " + appointment.getPatientId() + "\nNurse ID: " + appointment.getNurseId() + "\nDate: " + appointment.getDate() + "\nTime: " + appointment.getTime());

            }

            fileWriter.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("An Error occurred while saving the data.");
            e.printStackTrace();

        }

    }
    public void displayMainMenu() {

            System.out.println("Welcome to the Hospital Management System\n");

            System.out.println("----------------------------");
            System.out.println("| #1) Nurse                |");
            System.out.println("| #2) Receptionist         |");
            System.out.println("| #0) Exit                 |");
            System.out.println("----------------------------");

            System.out.println("Please Choose an option:    ");

    }
    public void displayNurseMenu() {

        System.out.println("Welcome to the Nurse Menu\n");

        System.out.println("**************************");
        System.out.println("| #1) Update patient file|");
        System.out.println("| #2) Change password    |");
        System.out.println("| #0) Back to main menu  |");
        System.out.println("**************************");

        System.out.println("Please Choose option:     ");

    }
    public void displayReceptionistMenu() {

        System.out.println("Welcome to the Receptionist Menu\n");

        System.out.println("<><><><><><><><><><><><><><><><>");
        System.out.println("| #1) Add new patient          |");
        System.out.println("| #2) Add new Nurse            |");
        System.out.println("| #3) Delete Nurse             |");
        System.out.println("| #4) Delete patient           |");
        System.out.println("| #5) Search Nurse             |");
        System.out.println("| #6) Search patient           |");
        System.out.println("| #7) Display all nurse        |");
        System.out.println("| #8) Display all patient      |");
        System.out.println("| #9) Set Appointment          |");
        System.out.println("| #10) Display all Appointment |");
        System.out.println("| #11) Search Appointment      |");
        System.out.println("| #12) Delete Appointment      |");
        System.out.println("| #0) Back to main menu        |");
        System.out.println("<><><><><><><><><><><><><><><><>");

        System.out.println("Please Choose option: ");

    }
    public boolean validateNurse(long id , String password) {

        try {

            for (Nurse nurse: nurses) {

                if (nurse.getId() == id && nurse.getPassword().equals(password)) {

                    return true;

                }

            }

        } catch (Exception e) {

            System.out.println("Such an ID is not valid or there is no nurse that can be found whose ID is valid...");

        }

        return false;

    }
    public Nurse findNurseById(long id) {

            for (Nurse nurse: nurses) {

                if (nurse.getId() == id) {

                    return nurse;

                }

            }

        return null;

    }
    public Patient findPatientById(long id) {

            for (Patient patient: patients) {

                if (patient.getId() == id) {

                    return patient;

                }

            }

        return null;

    }
    public Appointment findAppointmentById(long id) {

        for (Appointment appointment : appointments) {

            if (appointment.getId() == id) {

                return appointment;

            }

        }

        return null;

    }
    public void handleNurseOption() {

        try {

            System.out.println("Please Enter your nurse ID: ");
            long id = input.nextLong();

            System.out.println("Please Enter your password: ");
            String password = input.next();

            int attempts = 1;

            while (!validateNurse(id, password) && attempts < 3) {

                System.out.println("Invalid \"ID\" or \"Password\"\nPlease try again.");

                System.out.println("Please Enter your nurse ID:");
                id = input.nextLong();

                System.out.println("Please Enter your password: ");
                password = input.next();

                attempts++;

            }


            if (validateNurse(id, password)) {

                System.out.println("Login successfully.");
                Nurse nurse = findNurseById(id);
                int option = -1;

                while (option != 0) {

                    displayNurseMenu();
                    option = input.nextInt();

                    switch (option) {
                        case 1 -> updatePatientFile(nurse);
                        case 2 -> changePassword(nurse);
                        case 0 -> System.out.println("Back to main menu.");
                        default -> System.out.println("Invalid option.\nPlease try again.");
                    }

                }

            } else {

                System.out.println("You do not have permission to access the application.");

            }

        } catch (Exception e) {

            System.out.println("In your entries, be careful to enter the specified type correctly.\n" + "Enter again:\n");

            System.out.println("#Please Enter your nurse ID: ");

            long id = input.nextLong();

            System.out.println("#Please Enter your password: ");
            String password = input.next();

            int attempts = 1;

            while (!validateNurse(id, password) && attempts < 3) {

                System.out.println("Invalid \"ID\" or \"Password\"\nPlease try again.");

                System.out.println("Please Enter your nurse ID:");
                id = input.nextLong();

                System.out.println("Please Enter your password: ");
                password = input.next();

                attempts++;

            }


            if (validateNurse(id, password)) {

                System.out.println("Login successfully.");
                Nurse nurse = findNurseById(id);
                int option = -1;

                while (option != 0) {

                    displayNurseMenu();
                    option = input.nextInt();

                    switch (option) {
                        case 1 -> updatePatientFile(nurse);
                        case 2 -> changePassword(nurse);
                        case 0 -> System.out.println("Back to main menu.");
                        default -> System.out.println("Invalid option.\nPlease try again.");
                    }

                }

            } else {

                System.out.println("You do not have permission to access the application.");


            }
        }
    }
    public void updatePatientFile(Nurse nurse) {

        System.out.println("Please Enter the patient ID: ");
        long id = input.nextLong();

        Patient patient = findPatientById(id);

        try {

            if (patient != null) {

                System.out.println("The patient file is: ");
                System.out.println(patient);

                System.out.println("__________________________");
                System.out.println("| #1) Add a medicine     |");
                System.out.println("| #2) Remove a medicine  |");
                System.out.println("| #3) Update a medicine  |");
                System.out.println("| #0) Back to nurse menu |");
                System.out.println("--------------------------");

                System.out.println("Please choose an option:  ");

                int option = input.nextInt();

                switch (option) {
                    case 1 -> addMedicine(patient);
                    case 2 -> removeMedicine(patient);
                    case 3 -> updateMedicine(patient);
                    case 0 -> System.out.println("Back to nurse menu.");
                    default -> System.out.println("Invalid option Please try again.");
                }


            } else {

                System.out.println("No patient found with this id.");

            }

        } catch (Exception e) {

            System.out.println("In your entries, be careful to enter the specified type correctly.\n" + "Enter again:\n");

            if (patient != null) {

                System.out.println("The patient file is: ");
                System.out.println(patient);

                System.out.println("__________________________");
                System.out.println("| #1) Add a medicine     |");
                System.out.println("| #2) Remove a medicine  |");
                System.out.println("| #3) Update a medicine  |");
                System.out.println("| #0) Back to nurse menu |");
                System.out.println("--------------------------");

                System.out.println("Please choose an option:  ");

                int option = input.nextInt();

                switch (option) {
                    case 1 -> addMedicine(patient);
                    case 2 -> removeMedicine(patient);
                    case 3 -> updateMedicine(patient);
                    case 0 -> System.out.println("Back to nurse menu.");
                    default -> System.out.println("Invalid option Please try again.");
                }


            } else {

                System.out.println("No patient found with this id.");

            }

        }

    }
    public void addMedicine(Patient patient) {

        try {

            System.out.println("Please Enter the name of the medicine: ");
            String medicine = input.next();

            patient.addMedicine(medicine);
            System.out.println("Medicine added successfully.");

        } catch (Exception e) {

            System.out.println("In your entries, be careful to enter the specified type correctly.\n" + "Enter again:\n");
            e.printStackTrace();
            System.out.println("Please Enter the name of the medicine: ");
            String medicine = input.next();

            patient.addMedicine(medicine);
            System.out.println("Medicine added successfully.");

        }

    }
    public void removeMedicine(Patient patient) {

        try {

            System.out.println("Please Enter the name of the medicine: ");
            String medicine = input.next();

            if (patient.getMedicien().contains(medicine)) {

                patient.removeMedicine(medicine);
                System.out.println("Medicine removed successfully.");

            } else {

                System.out.println("No medicine found with this name.");

            }

        } catch (Exception e) {

            System.out.println("In your entries, be careful to enter the specified type correctly.\n" + "Enter again:\n");
            e.printStackTrace();

            System.out.println("Please Enter the name of the medicine: ");
            String medicine = input.next();

            if (patient.getMedicien().contains(medicine)) {

                patient.removeMedicine(medicine);
                System.out.println("Medicine removed successfully.");

            } else {

                System.out.println("No medicine found with this name.");

            }

        }

    }
    public void updateMedicine(Patient patient) {

            System.out.println("Please Enter the name of the old medicine: ");
            String oldMedicine = input.next();

            if (patient.getMedicien().contains(oldMedicine)) {
                System.out.println("Please Enter the name of new medicine: ");
                String newMedicine = input.next();

                patient.updateMedicine(oldMedicine , newMedicine);
                System.out.println("Medicine updated successfully.");

            } else  {

                System.out.println("No medicine found with this name.");

            }

    }
    public void changePassword(Nurse nurse) {

            System.out.println("Please Enter your old password: ");
            String oldPassword = input.next();

            if (nurse.getPassword().equals(oldPassword)) {

                System.out.println("Please Enter the your new password: ");
                String newPassword = input.next();

                nurse.setPassword(newPassword);
                System.out.println("Password changed successfully.");

            } else {

                System.out.println("Worng password !!\n Please try again...");

            }

    }
    public void handleReceptionistOption() {

        int option = -1;

        while (option != 0) {

            displayReceptionistMenu();
            option = input.nextInt();
            switch (option) {

                case 1 -> addNewPatient();
                case 2 -> addNewNurse();
                case 3 -> deleteNurse();
                case 4 -> deletePatient();
                case 5 -> searchNurse();
                case 6 -> searchPatient();
                case 7 -> displayAllNurses();
                case 8 -> displayAllPatients();
                case 9 -> setAppointment();
                case 10 -> displayAllAppointment();
                case 11 -> searchAppointments();
                case 12 -> deleteAppointment();

                case 0 -> System.out.println("Back to main menu.");

                default -> System.out.println("Invalid option !!\n Please try again...");

            }

        }

    }
    public void addNewPatient() {

            System.out.println("Please Enter the patient ID: ");
            long id = input.nextLong();

            if (findPatientById(id) == null) {

                System.out.println("Please Enter the patient first name: ");
                String fname = input.next();
                System.out.println("Please Enter the patient last name: ");
                String lname = input.next();

                System.out.println("Please enter the name of the relevant doctor: ");
                String doctor = input.next();

                System.out.println("Please enter the date the patient was admitted: ");
                String date = input.next();

                System.out.println("Please Enter the patient diagnosis: ");
                String diagnosis = input.next();

                Patient patient = new Patient(fname , lname , id , doctor, date , diagnosis);
                patients.add(patient);

                System.out.println("Patient added successfully.");

            } else {

                System.out.println("A patient with this id already exists.");

            }

    }
    public void setAppointment() {

        System.out.println("Please Enter the ID of the Appointment: ");
        long id = input.nextLong();

        if (findAppointmentById(id) == null) {

            System.out.println("Enter the Nurse ID: ");
            long nurseId = input.nextLong();
            System.out.println("Enter the Patient ID: ");
            long patientId = input.nextLong();

            if (findNurseById(nurseId) != null && findPatientById(patientId) != null) {

                System.out.println("Please Enter the Date: ");
                String date = input.next();
                System.out.println("Please Enter the Time: ");
                String time = input.next();

                Appointment appointment = new Appointment(id, patientId, nurseId, date, time);

                appointments.add(appointment);


                System.out.println("Appointment information has been successfully registered.");


            }

        } else {

            System.out.println("A Appointment with this id already exists.");

        }

    }
    public void addNewNurse() {

            System.out.println("Please Enter the Nurse ID: ");
            long id = input.nextLong();

            if (findNurseById(id) == null) {

                System.out.println("Please Enter the Nurse first name: ");
                String fname = input.next();
                System.out.println("Please Enter the Nurse last name: ");
                String lname = input.next();

                System.out.println("Please Enter the patient password: ");
                String password = input.next();

                Nurse nurse = new Nurse(fname , lname , password , id );
                nurses.add(nurse);
                System.out.println("Nurse added successfully.");

            } else {

                System.out.println("A patient with this id already exists.");

            }

    }
    public void deleteNurse() {

            System.out.println("Please Enter the nurse ID: ");
            long id = input.nextLong();

            Nurse nurse = findNurseById(id);

            if (nurse != null) {

                nurses.remove(nurse);
                System.out.println("Nurse deleted successfully.");

            } else {

                System.out.println("No nurse found with this id.");

            }

    }
    public void deleteAppointment() {

        System.out.println("Please Enter the appointment ID: ");
        long appointmentID = input.nextLong();

        Appointment appointment = findAppointmentById(appointmentID);

        if (appointment != null) {

            appointments.remove(appointment);
            System.out.println("Appointment deleted successfully.");

        } else {

            System.out.println("No nurse found with this id.");

        }

    }
    public void deletePatient() {

            System.out.println("Please Enter the patient ID: ");
            long id = input.nextLong();

            Patient patient = findPatientById(id);

            if (patient != null) {

                patients.remove(patient);
                System.out.println("Patient deleted successfully.");

            } else  {

                System.out.println("No patient found with this id.");

            }

    }
    public void searchNurse() {

            System.out.println("Please Enter the nurse ID: ");
            long id = input.nextLong();

            Nurse nurse = findNurseById(id);

            if (nurse != null) {

                System.out.println("The nurse file is: ");
                System.out.println(nurse);

            } else {

                System.out.println("No nurse found with this id.");

            }

    }
    public void searchPatient() {

            System.out.println("Please Enter the patient ID: ");
            long id = input.nextLong();

            Patient patient = findPatientById(id);

            if (patient != null) {

                System.out.println("The patient file is: ");
                System.out.println(patient);

            } else {

                System.out.println("No patient found with this id.");

            }


    }
    public void searchAppointments() {

        System.out.println("Please Enter the Appointment ID: ");
        long appointmentId = input.nextLong();

        Appointment appointment = findAppointmentById(appointmentId);

        if (appointment != null) {

            System.out.println("The Appointment is: ");
            System.out.println(appointment);


        } else {

            System.out.println("No Appointment found with this id.");

        }

    }
    public void displayAllNurses() {

        System.out.println("The list of all nurse is: ");

        for (int i = 0; i < nurses.size() - 1; i++) {
            for (int j = 0; j < nurses.size() - i - 1; j++) {

                if (nurses.get(i).getId() > nurses.get(j + 1).getId()) {

                    Nurse temp = nurses.get(i);
                    nurses.set(j,nurses.get(j+1));
                    nurses.set(j+1 , temp);

                }

            }

        }

        for (Nurse nurse : nurses) {

            System.out.println(nurse);

        }

    }
    public void displayAllPatients() {

        System.out.println("The list of all patient is: ");

        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {

                if (patients.get(j).getId() > patients.get(j + 1).getId()) {

                    Patient temp = patients.get(j);
                    patients.set(j , patients.get(j + 1));
                    patients.set(j + 1 , temp);

                }

            }

        }

        for (Patient patient : patients) {

            System.out.println(patient);

        }

    }
    private void displayAllAppointment() {

        System.out.println("The list of all patient is: ");

        for (int i = 0; i < appointments.size() - 1; i++) {
            for (int j = 0; j < appointments.size() - i - 1; j++) {

                if (appointments.get(j).getId() > appointments.get(j + 1).getId()) {

                    Appointment temp = appointments.get(j);
                    appointments.set(j , appointments.get(j + 1));
                    appointments.set(j + 1 , temp);

                }

            }

        }

        for (Appointment appointment : appointments) {

            System.out.println(appointment);

        }

    }
    public void run() {

        loadData();
        int option = -1;
        while (option != 0) {

            displayMainMenu();
            option = input.nextInt();
            switch (option) {
                case 1 -> handleNurseOption();
                case 2 -> handleReceptionistOption();
                case 0 -> System.out.println("Exiting the application.");
                default -> System.out.println("Invalid option !!\nPlease try again.");
            }

        }

        savaData();

    }

}