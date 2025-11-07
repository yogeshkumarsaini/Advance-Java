import Models.Appointments;
import Models.Doctors;
import Models.Patients;
import Service.AppointmentService;
import Service.DoctorService;
import Service.PatientService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PatientService patientService = new PatientService();
    private static DoctorService doctorService = new DoctorService();
    private static AppointmentService appointmentService=new AppointmentService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\n1. Patient\n2. Doctor\n3. Appointment\n4. Exit\nSelect an option:");
                int category = sc.nextInt();
                sc.nextLine();

                switch (category) {
                    case 1:
                        handlePatientOptions();
                        break;
                    case 2:
                        handleDoctorOptions();
                        break;
                    case 3:
                        handleAppointmentOptions();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void handlePatientOptions() throws SQLException {
        System.out.println("\n1. Insert Patient Details\n2. Display All Patients Details\n3. Get Patient by ID\n4. Update Patient Details\n5. Delete Patient Details\n6. Exits\nSelect an option:");
        int patientChoice = sc.nextInt();
        sc.nextLine();

        switch (patientChoice) {
            case 1:
                addPatient();
                break;
            case 2:
                getAllPatient();
                break;
            case 3:
                getPatientById();
                break;
            case 4:
                updatePatient();
                break;
            case 5:
                deletePatient();
                break;
            case 6:
                System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void handleDoctorOptions() throws SQLException {
        System.out.println("\n1. Insert Doctors Details\n2. Display All Doctors Details\n3. Get Doctor by ID\n4. Update Doctor Details\n5. Delete Doctor\n6. Exits\nSelect an option:");
        int doctorChoice = sc.nextInt();
        sc.nextLine();

        switch (doctorChoice) {
            case 1:
                addDoctor();
                break;
            case 2:
                getAllDoctors();
                break;
            case 3:
                getDoctorByID();
                break;
            case 4:
                updateDoctor();
                break;
            case 5:
                deleteDoctor();
                break;
            case 6:
                System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void handleAppointmentOptions() throws SQLException {
        System.out.println("\n1. Insert Appointment Details\n2. Display All Appointment Details\n3. Get All Details Appointments\n4. Get Appointment by ID\n5. Update Appointment Details\n6. Delete Appointment\n7. Exits\nSelect an option:");
        int appointmentChoice = sc.nextInt();
        sc.nextLine();

        switch (appointmentChoice) {
            case 1:
                addAppointment();
                break;
            case 2:
                getAllAppointments();
                break;
            case 3:
                getDetailedAppointments();
                break;
            case 4:
                getAppointmentById();
                break;
            case 5:
                updateAppointment();
                break;
            case 6:
                deleteAppointment();
                break;
            case 7:
                System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void addPatient() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        Patients patient = new Patients();
        patient.setName(name);
        patient.setDateOfBirth(dateOfBirth);
        patient.setGender(gender);
        patient.setContactNumber(contactNumber);
        patient.setAddress(address);

        patientService.addPatient(patient);

        System.out.println("Patient added successfully!");
    }

    private static void getAllPatient() throws SQLException {
        List<Patients> patients = patientService.getAllPatient();
        System.out.println("\nPatients List:");
        for (Patients patient : patients) {
            System.out.println("ID: " + patient.getId() + ", Name: " + patient.getName() + ", Date of Birth: " + patient.getDateOfBirth() + ", Gender: " + patient.getGender() + ", Contact Number: " + patient.getContactNumber() + ", Address: " + patient.getAddress());
        }
    }

    private static void getPatientById() throws SQLException {
        System.out.print("Enter patient ID to view: ");
        int id = Integer.parseInt(sc.nextLine());

        Patients patients = patientService.getPatientById(id);
        if (patients != null) {
            System.out.println("ID: " + patients.getId() + ", Name: " + patients.getName() + ", Date of Birth: " + patients.getDateOfBirth() + ", Gender: " + patients.getGender() + ", Contact Number: " + patients.getContactNumber() + ", Address: " + patients.getAddress());
        } else {
            System.out.println("Patients not found with ID: " + id);
        }
    }


    private static void updatePatient() throws SQLException {
        System.out.print("Enter patient ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.println("Enter the new Date of Birth");
        String dateOfBirth = sc.nextLine();
        System.out.println("Enter the new gender");
        String gender = sc.nextLine();
        System.out.println("Enter the new Contact number");
        String contactNumber = sc.nextLine();
        System.out.println("Enter the new Address");
        String address = sc.nextLine();

        Patients patients = new Patients();
        patients.setId(id);
        patients.setName(name);
        patients.setDateOfBirth(dateOfBirth);
        patients.setGender(gender);
        patients.setContactNumber(contactNumber);
        patients.setAddress(address);

        patientService.updatePatient(patients);

        System.out.println("Patient updated successfully!");
    }

    private static void deletePatient() throws SQLException {
        System.out.print("Enter patient ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        patientService.deletePatient(id);
        System.out.println("Patient deleted successfully!");
    }

    private static void addDoctor() throws SQLException {
        System.out.println("Enter the name");
        String name = sc.nextLine();
        System.out.println("Enter the specialization");
        String specialization = sc.nextLine();
        System.out.println("Enter the contact number");
        String contactNumber = sc.nextLine();
        System.out.println("Enter the email");
        String email = sc.nextLine();

        Doctors doctors = new Doctors();
        doctors.setName(name);
        doctors.setSpecialization(specialization);
        doctors.setContactNumber(contactNumber);
        doctors.setEmail(email);

        doctorService.addDoctor(doctors);
        System.out.println("Doctor added sucessfully!");
    }

    private static void getAllDoctors() throws SQLException {
        List<Doctors> doctors = doctorService.getAllDoctors();
        System.out.println("\nDoctors List:");
        for (Doctors doctor : doctors) {
            System.out.println("ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization() + ", Conatact Number: " + doctor.getContactNumber() + ", Email: " + doctor.getEmail());
        }
    }

    private static void getDoctorByID() throws SQLException {
        System.out.print("Enter Doctor ID to view: ");
        int id = Integer.parseInt(sc.nextLine());

        Doctors doctors = doctorService.getDoctorByID(id);
        if (doctors != null) {
            System.out.println("ID: " + doctors.getId() + ", Name: " + doctors.getName() + ", Specialization: " + doctors.getSpecialization() + ", Contact Number: " + doctors.getContactNumber() + ", Email: " + doctors.getEmail());
        } else {
            System.out.println("Doctor not found with ID: " + id);
        }
    }


    private static void updateDoctor() throws SQLException {
        System.out.print("Enter doctor ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.println("Enter the new Specialization");
        String specialization = sc.nextLine();
        System.out.println("Enter the new Contact number");
        String contactNumber = sc.nextLine();
        System.out.println("Enter the new Email");
        String email = sc.nextLine();

        Doctors doctors = new Doctors();
        doctors.setId(id);
        doctors.setName(name);
        doctors.setSpecialization(specialization);
        doctors.setContactNumber(contactNumber);
        doctors.setEmail(email);

        doctorService.updateDoctor(doctors);

        System.out.println("Doctor updated successfully!");
    }

    private static void deleteDoctor() throws SQLException {
        System.out.print("Enter doctors ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        doctorService.deleteDoctor(id);
        System.out.println("Doctor deleted successfully!");
    }

    private static void addAppointment() throws SQLException{
        System.out.println("Enter the Patient Id: ");
        int patientId= sc.nextInt();
        System.out.println("Enter the Doctor Id: ");
        int doctorId= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Appointment Date (YYYY-MM-DD): ");
        String appointmentDate=sc.nextLine();

        System.out.println("Enter the Appointment Reason: ");
        String appointmentReason=sc.nextLine();


        Appointments appointments = new Appointments();
        appointments.setPatientId(patientId);
        appointments.setDoctorId(doctorId);
        appointments.setAppointmentDate(appointmentDate);
        appointments.setAppointmentReason(appointmentReason);

        appointmentService.addAppointment(appointments);
        System.out.println("Appointment added Sucessfully!");
    }

    private static void getAllAppointments() throws SQLException{
        List<Appointments> appointments =appointmentService.getAllAppointments();
        System.out.println("\nAppointment List: ");
       for (Appointments appointment :appointments){
           System.out.println("Appointment ID: " +appointment.getId()+", Patient ID: "+appointment.getPatientId()+", Doctor ID: "+appointment.getDoctorId()+", Appointment Date: "+appointment.getAppointmentDate()+", Appointment Reason: "+appointment.getAppointmentReason());
       }
    }

    private static void getDetailedAppointments() throws SQLException{
        List<String> detailedAppointments = appointmentService.getDetailedAppointments();
        System.out.println("Detailed Appointments:");
        for (String detailedAppointment : detailedAppointments) {
            System.out.println(detailedAppointment);
            System.out.println();
        }
    }
    private static void getAppointmentById() throws SQLException {
        System.out.print("Enter Appointment ID to view: ");
        int id = Integer.parseInt(sc.nextLine());

        Appointments appointments=appointmentService.getAppointmentById(id);
        if (appointments != null) {
            System.out.println("Appointment ID: " + appointments.getId() + ", Patient ID: " + appointments.getPatientId() + ", Doctor ID: " + appointments.getDoctorId() + ", Appointment Date: " + appointments.getAppointmentDate() + ", Appointment Reason: " + appointments.getAppointmentReason());
        } else {
            System.out.println("Appointment not found with ID: " + id);
        }
    }


    private static void updateAppointment() throws SQLException {
        System.out.print("Enter Appointment ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter new Patient Id: ");
       int patientId=sc.nextInt();
        System.out.println("Enter the new Doctor Id");
        int doctorId =sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new Appointment Date");
        String appointmentDate = sc.nextLine();
        System.out.println("Enter the new Appointment Reason");
        String appointmentReason = sc.nextLine();

        Appointments appointments=new Appointments();
        appointments.setId(id);
        appointments.setPatientId(patientId);
        appointments.setDoctorId(doctorId);
        appointments.setAppointmentDate(appointmentDate);
        appointments.setAppointmentReason(appointmentReason);

        appointmentService.updateAppointment(appointments);

        System.out.println("Appointment updated successfully!");
    }

    private static void deleteAppointment() throws SQLException {
        System.out.print("Enter Appointment ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        appointmentService.deleteAppointment(id);
        System.out.println("Appointment deleted successfully!");
    }


}
