/**
 * Demonstrates a doctor within a hospital system.
 * A doctor is characterized by a name, an ID, a specialization, and can have up to four patients assigned.
 */
public class Doctor {
    private String doctorName;
    private String doctorID;
    private String specialization;
    private int[] patientIDs = new int[4]; // Changed to an int array
    private int noOfPatients = 0;
    private boolean isAvailable = true;

    /**
     * Constructs a new Doctor with specified details.
     *
     * @param doctorName The name of the doctor.
     * @param doctorID The unique identifier for the doctor.
     * @param specialization The doctor's area of expertise.
     */
    public Doctor(String doctorName, String doctorID, String specialization) {
        this.doctorName = doctorName;
        this.doctorID = doctorID;
        this.specialization = specialization;
    }

    // Accessors and Mutators
    public String getDoctorName() {
        return doctorName;
    }

    //Sets the doctor's name.
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    //Gets the doctor's unique ID.
    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    //Gets the doctor's specialization.
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Checks if the doctor is available to take more patients.
     * A doctor is considered available if they have fewer than four patients.
     * @return true if the doctor is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }
    /**
     * Assigns a patient to this doctor.
     * If the doctor already has four patients, prints a message indicating they cannot accept more patients.
     * @param patientID The ID of the patient to assign to this doctor.
     */
    public void assignPatientID(int patientID) { // Parameter type changed to int
        if (noOfPatients < patientIDs.length) {
            patientIDs[noOfPatients] = patientID; // Assign the patient ID to the array.
            noOfPatients++; // Increment the number of patients.

            if (noOfPatients == patientIDs.length) {
                isAvailable = false;
                System.out.println(getDoctorName() + " has now reached full capacity with the addition number of patient "
                        + patientID + " and cannot accept more patients.");
            }
        } else {
            System.out.println(getDoctorName() + " is already full and cannot accept more patients.");
        }
    }
    /**
     * Removes a patient from this doctor's list of patients.
     * If the patient is found, they are removed and the list is adjusted.
     * Otherwise, prints a message indicating the patient was not found.
     * @param patientID The ID of the patient to remove from this doctor's list.
     */
    public void removePatientID(int patientID) { // Parameter type changed to int
        // Flag to track if the patientID has been found
        boolean found = false;
        // Iterate through the array of patient IDs
        for (int i = 0; i < noOfPatients; i++) {
            // Check if the current element matches the patientID we're looking for
            if (patientIDs[i] == patientID) { // Use == for primitive int comparison
                // Mark as found
                found = true;
                // Shift all subsequent patient IDs one position to the left to remove the matching ID
                for (int j = i; j < noOfPatients - 1; j++) {
                    patientIDs[j] = patientIDs[j + 1];
                }
                // Decrement the count of patients and reset the last element to 0
                patientIDs[--noOfPatients] = 0;
                // Mark that some change has been made (e.g., patient removal), could affect availability
                isAvailable = true;
                // Inform that the patient ID has been removed from this doctor's patient list
                System.out.println("Patient with ID " + patientID + " has been removed from Dr. " + this.getDoctorName() + "'s patient list.");
                // Exit the loop as the job is done
                break;
            }
        }
        // If the patientID was not found in the list, inform the user
        if (!found) {
            System.out.println("Patient ID " + patientID + " was not found in Dr. " + this.getDoctorName() + "'s patient list.");
        }
    }


    /**
     * Returns a string representation of the doctor, including their name, ID, specialization, and list of patient IDs.
     * @return A string representation of the doctor.
     */

    @Override
    public String toString() {
        StringBuilder patientsList = new StringBuilder("[");
        for (int i = 0; i < noOfPatients; i++) {
            patientsList.append(patientIDs[i]);
            if (i < noOfPatients - 1) {
                patientsList.append(", ");
            }
        }
        patientsList.append("]");
        return "Doctor{" +
                "doctorName='" + doctorName + '\'' +
                ", doctorID='" + doctorID + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patients=" + patientsList +
                ", noOfPatients=" + noOfPatients +
                ", isAvailable=" + isAvailable + '}';
    }
}
