/**
 * Symbolizes a hospital that can accommodate both patients and physicians.
 * It enables searching for patients by name or ID, as well as adding and removing physicians.
 * Additionally, this class oversees the matching of patients with doctors according to availability..
 */
public class Hospital {
    private String hospitalName;
    private int numberOfDoctors;
    private int numberOfPatients;
    private Doctor[] doctors;
    private Patient[] patients;
    private int sizeOfDoctors;
    private int sizeOfPatients;

    /**
     * Constructs a Hospital instance with specified capacities for doctors and patients.
     * Initializes the hospital with the given name and capacities for doctors and patients.
     * The arrays for doctors and patients are initialized according to the specified capacities.
     *
     * @param name            The name of the hospital.
     * @param doctorCapacity  The maximum number of doctors the hospital can accommodate.
     * @param patientCapacity The maximum number of patients the hospital can accommodate.
     */
    public Hospital(String name, int doctorCapacity, int patientCapacity) {
        this.hospitalName = name;
        this.sizeOfDoctors = doctorCapacity;
        this.sizeOfPatients = patientCapacity;
        this.doctors = new Doctor[doctorCapacity];
        this.patients = new Patient[patientCapacity];
        this.numberOfDoctors = 0;
        this.numberOfPatients = 0;
    }

    /**
     * Adds a patient to the hospital. If there's an available doctor, assigns the patient to them.
     *
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        // Check if there is capacity to add more patients
        if (numberOfPatients >= sizeOfPatients) {
            System.out.println("Hospital capacity for patients reached. Cannot add more patients..!");
            return; // Early return to avoid deep nesting
        }

        // Add the patient to the hospital's list
        patients[numberOfPatients] = patient;
        numberOfPatients++; // Increment the counter for total patients

        // Repeat through the list of doctors to find an available one
        for (int i = 0; i < doctors.length; i++) {
            Doctor doctor = doctors[i];
            // Check if the doctor is available
            if (doctor != null && doctor.isAvailable()) {
                // Assign the patient to this doctor
                doctor.assignPatientID(patient.getPatientID());
                patient.setDoctor(doctor);
                break; // Exit the loop once a doctor is assigned
            }
        }
    }


    /**
     * Adds a doctor to the hospital.
     *
     * @param d The doctor to add.
     */
    public void addDoctor(Doctor d) {
        // Check if there's still space to add a new doctor within the predefined capacity
        if (numberOfDoctors < sizeOfDoctors) {
            // Assign the doctor to the next available position in the array
            // and increment the number of doctors currently added
            doctors[numberOfDoctors++] = d;
        } else {
            // If the hospital has reached its capacity for doctors, print a message
            // indicating no more doctors can be added
            System.out.println("Hospital capacity for doctors reached. Cannot add more doctors.");
        }
    }


    /**
     * Finds a patient in the hospital by their name.
     * Searches through the list of patients and returns the first one with a matching name.
     * If no patient with the specified name is found, returns null.
     *
     * @param name The name of the patient to find.
     * @return The patient if found, null otherwise.
     */
    public Patient findPatient(String name) {
        // Repeat through the array of patients
        for (int i = 0; i < patients.length; i++) {
            // Temporary variable to store the current patient in the loop
            Patient p = patients[i];
            // Check if the current patient is not null and if their name matches the searched name
            if (p != null && p.getPatientName().equals(name)) {
                // If a match is found, return the current patient
                return p;
            }
        }
        // If no matching patient is found after searching the entire array, return null
        return null;
    }


    /**
     * Finds a doctor in the hospital by their ID.
     * Searches through the list of doctors and returns the one with a matching ID.
     * If no doctor with the specified ID is found, returns null.
     *
     * @param id The ID of the doctor to find.
     * @return The doctor if found, null otherwise.
     */
    public Doctor findDoctor(String id) {
        // Repeat through the array of doctors
        for (int i = 0; i < doctors.length; i++) {
            // Temporary variable to hold the current doctor in the loop
            Doctor d = doctors[i];
            // Check if the current doctor is not null and if their ID matches the searched ID
            if (d != null && d.getDoctorID().equals(id)) {
                // If a match is found, return the current doctor
                return d;
            }
        }
        // If no matching doctor is found, return null
        return null;
    }


    /**
     * Removes a patient from the hospital, and if they're assigned to a doctor, removes them from the doctor's patient list as well.
     * Searches for the patient in the hospital and removes them if found. If the patient is assigned to a doctor,
     * also removes the patient from the doctor's list of patients.
     * Prints a message indicating the patient has been discharged, or that the patient was not found if applicable.
     *
     * @param patient The patient to remove.
     */
    public void removePatient(Patient patient) {
        // Iterate through the list of patients
        for (int i = 0; i < numberOfPatients; i++) {
            // Check if the current patient is the one to be removed
            if (patients[i].equals(patient)) { // Assuming Patient class overrides equals() appropriately
                // If the patient has a doctor assigned, remove this patient from the doctor's list
                if (patients[i].getDoctor() != null) {
                    patients[i].getDoctor().removePatientID(patient.getPatientID());
                }
                // Shift the elements in the array to fill the gap left by the removed patient
                System.arraycopy(patients, i + 1, patients, i, numberOfPatients - i - 1);
                // Decrement the number of patients and nullify the last element in the array
                patients[--numberOfPatients] = null;
                // Print a message indicating the patient has been discharged
                System.out.println(patient.getPatientName() + " has been discharged from the hospital.");
                return; // Exit the method after successfully removing the patient
            }
        }
        // If the patient is not found in the list, print a message indicating so
        System.out.println("Patient " + patient.getPatientName() + " was not found in the hospital.");
    }


    // Getters

    public String getHospitalName() {
        return hospitalName;
    }

    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public int getSizeOfDoctors() {
        return sizeOfDoctors;
    }

    public int getSizeOfPatients() {
        return sizeOfPatients;
    }

    //Setters
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void setSizeOfDoctors(int sizeOfDoctors) {
        this.sizeOfDoctors = sizeOfDoctors;
    }

    public void setSizeOfPatients(int sizeOfPatients) {
        this.sizeOfPatients = sizeOfPatients;
    }

}
