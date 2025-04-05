/**
 * Serves as a patient's representative inside a medical system.
 * This class contains information about the patient such as name, ID, entry date,
 * and the assigned doctor. It supports changing the patient's details and provides
 * functionality to compare patient objects.
 */
public class Patient {
    private String patientName;
    private int patientID; // Patient ID is now of type int
    private String entryDate;
    private Doctor doctor;

    /**
     * Constructs a new Patient instance with specified name, ID, and entry date.
     * Initially, no doctor is assigned to the patient.
     *
     * @param patientName the name of the patient
     * @param patientID   the unique ID of the patient
     * @param entryDate   the entry date of the patient to the healthcare system
     */
    public Patient(String patientName, int patientID, String entryDate) {
        this.patientName = patientName;
        this.patientID = patientID;
        this.entryDate = entryDate;
        this.doctor = null;
    }

    /**
     * Copy constructor creates a new Patient instance by copying the details from another patient.
     * Note: This creates a shallow copy; the doctor field is copied directly, not cloned.
     *
     * @param other the Patient object to copy from
     */
    public Patient(Patient other) {
        this.patientName = other.patientName;
        this.patientID = other.patientID;
        this.entryDate = other.entryDate;
        this.doctor = other.doctor;
    }

    // Accessors and Mutators (Getters and Setters)

    /**
     * Returns the patient's name.
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Sets the patient's name.
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * Returns the patient's ID.
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Sets the patient's ID.
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * Returns the patient's entry date.
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * Sets the patient's entry date.
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * Returns the assigned doctor, or null if no doctor is assigned.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Assigns a doctor to the patient.
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Returns a string representation of the Patient object.
     * Includes patient name, ID, entry date, and assigned doctor's name.
     */
    @Override
    public String toString() {
        return "Patient{" + "patientName='" + patientName + '\'' + ", patientID=" + patientID + ", entryDate='" + entryDate + '\'' + ", doctor=" + (doctor != null ? doctor.getDoctorName() : "None") + '}';
    }

    /**
     * Compares this patient to another object for equality.
     * Patients are considered equal if they have the same patient ID.
     *
     * @param o the object to compare with this Patient
     * @return true if the specified object is a Patient with the same ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID;
    }
}
