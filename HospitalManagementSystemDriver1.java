/**
 * The HospitalManagementSystemDriver1 shows as the entry point for the program.
 * It executes a series of operations demonstrating the use of the Hospital Management System,
 * including the creation of hospital, doctor, and patient objects, and the interactions among them.
 * Operations include initializing the hospital, creating and adding doctors and patients,
 * assigning patients to doctors, and displaying information about doctors and patients within the hospital.
 * It also demonstrates finding a specific doctor and patient by ID and name, respectively,
 * and removing a patient from the hospital.
 */
public class HospitalManagementSystemDriver1 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("KALP Hospital", 5, 10);
        //Initializes and displays information about a new hospital.
        System.out.println("Hospital Initialized: " + hospital.getHospitalName());
        System.out.println("Hospital capacity - Doctors: " + hospital.getSizeOfDoctors() + ", Patients: " + hospital.getSizeOfPatients());
        System.out.println("********************************************************");

        // Creating Patient objects with integer IDs
        Patient patient1 = new Patient("Ali KAYA", 1, "2024-03-04");
        Patient patient2 = new Patient("Can MUTLU", 2, "2024-03-06");
        Patient patient3 = new Patient("Zeynep ÖZ", 3, "2024-03-04");
        Patient patient4 = new Patient("Cem SEVEN", 4, "2024-03-06");
        Patient patient5 = new Patient("Hande ERSÖZ", 5, "2024-03-06");
        Patient patient6 = new Patient("Zehra YOLCU", 6, "2024-03-04");
        Patient patient7 = new Patient("Hakan CAN", 7, "2024-03-06");
        Patient patient8 = new Patient("Murat VARLIK", 8, "2024-03-06");
        Patient patient9 = new Patient("Halit VARLIK", 9, "2024-03-06");
        Patient patient10 = new Patient("Yıldız VARLIK", 10, "2024-03-06");
        Patient patient11 = new Patient("Sevil VARLIK", 11, "2024-03-06");
        System.out.println("Patients Objects Created.");
        System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");

        // Creating Doctor objects
        Doctor doctor1 = new Doctor("Dr. ELİF KALE", "D001", "Dermatology");
        Doctor doctor2 = new Doctor("Dr. ASLI ATEŞ", "D002", "Cardiology");
        Doctor doctor3 = new Doctor("Dr. CAN BAYRAK", "D003", "Immunologists");
        System.out.println("Doctors Objects Created.");
        System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");

        // Adding doctors to the hospital
        hospital.addDoctor(doctor1);
        System.out.println("Added " + doctor1.getDoctorName() + " to " + hospital.getHospitalName());
        hospital.addDoctor(doctor2);
        System.out.println("Added " + doctor2.getDoctorName() + " to " + hospital.getHospitalName());
        hospital.addDoctor(doctor3);
        System.out.println("Added " + doctor3.getDoctorName() + " to " + hospital.getHospitalName());

        // Adding patients to the hospital
        hospital.addPatient(patient1);
        System.out.println("Admitted " + patient1.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient2);
        System.out.println("Admitted " + patient2.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient3);
        System.out.println("Admitted " + patient3.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient4);
        System.out.println("Admitted " + patient4.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient5);
        System.out.println("Admitted " + patient5.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient6);
        System.out.println("Admitted " + patient6.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient7);
        System.out.println("Admitted " + patient7.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient8);
        System.out.println("Admitted " + patient8.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient9);
        System.out.println("Admitted " + patient9.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient10);
        System.out.println("Admitted " + patient10.getPatientName() + " to " + hospital.getHospitalName());
        hospital.addPatient(patient11);
        System.out.println("Not accepted " + patient11.getPatientName() + " to " + hospital.getHospitalName() + " because the hospital capacity was full.");

        System.out.println("Patients admitted to the hospital and assigned to doctors.");

        doctor1.assignPatientID(5); // Warning of Dr. ELİF KALE is already full and cannot accept more patients.


        System.out.println("\n /**** Hospital information is listed below ****/");
        // Get and print details of all doctors and patients
        System.out.println("Hospital Doctors:");


        // Iterate through the array or collection of doctors obtained from the hospital object
        for (Doctor doctor : hospital.getDoctors()) {
            // Check if the current doctor object is not null to avoid NullPointerException
            if (doctor != null) {
                // Print the doctor object to the console
                // This relies on the Doctor class having an appropriate toString() method overridden
                // for meaningful output, such as doctor's name, ID, specialty, so on.
                System.out.println(doctor);
            }
        }

        System.out.println("Hospital Patients:");
        for (Patient patient : hospital.getPatients()) {
            if (patient != null) { // Check if the current Patient object is not null to avoid NullPointerException
                System.out.println(patient);
            }
        }

        // Test finding a doctor by ID
        Doctor foundDoctor = hospital.findDoctor("D003");
        if (foundDoctor != null) {
            System.out.println("\nFound Doctor by ID (D003): " + foundDoctor.getDoctorName() + ", Specialization: " + foundDoctor.getSpecialization());
        } else {
            System.out.println("\nDoctor with ID D001 not found.");
        }


        // Test finding a patient by name
        Patient foundPatient = hospital.findPatient("Ali KAYA");
        if (foundPatient != null) {
            System.out.println("Found Patient by Name (Ali KAYA): " + foundPatient.getPatientName() + ", ID: " + foundPatient.getPatientID() + ", Admission Date: " + foundPatient.getEntryDate());
        } else {
            System.out.println("Patient named Ali KAYA not found.");
        }

        // Display initial state
        System.out.println("\nInitial State:");
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println(doctor3);

        System.out.println("Number of doctors in the hospital: " + hospital.getNumberOfDoctors());
        System.out.println("Number of patients in the hospital: " + hospital.getNumberOfPatients());
        System.out.println();

        // Find and remove a specific patient by name

        //Warning! Patient names are case-sensitive.
        // Please enter the patient name with the value originally assigned.
        Patient patientToRemove = hospital.findPatient("Hande ERSÖZ");
        if (patientToRemove != null) {
            hospital.removePatient(patientToRemove);
            System.out.println("\nRemoved patient: " + patientToRemove.getPatientName());
        } else {
            System.out.println("\nPatient not found.");
        }

        // Display state after removal
        System.out.println("\nState After Patient Removal:");
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println(doctor3);
        System.out.println("Number of doctors in the hospital: " + hospital.getNumberOfDoctors());
        System.out.println("Number of patients in the hospital: " + hospital.getNumberOfPatients());
    }
}
