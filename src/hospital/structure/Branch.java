package hospital.structure;

import employees.Doctor;
import interfaces.CapacityManager;
import interfaces.Registrable;
import patients.Patient;

import java.util.Arrays;

public abstract class Branch implements CapacityManager, Registrable {

    protected String name;
    protected Doctor[] doctors;
    protected int currentCapacity = 0;
    protected int maxCapacity;
    protected Patient[] patients = new Patient[0];

    public Patient[] getPatients() {
        return patients;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int capacity) {
        if (capacity < currentCapacity)
            System.out.println("The maximum capacity must not be less than the number of current patients");
        this.maxCapacity = capacity;
    }

    @Override
    public boolean canRegister() {
        return currentCapacity < maxCapacity;
    }

    public void addPatient(Patient patient) {
        patients = Arrays.copyOf(patients, patients.length + 1);
        if (canRegister()) {
            patients[currentCapacity] = patient;
            currentCapacity++; // counts beds which are used in a branch
            Hospital.currentPatients++; // counts all patients in hospital
        }
    }

    public void showPatients() {
        if (currentCapacity == 0) {
            System.out.println("No patients in " + name);
        } else {
            for (int i = 0; i < currentCapacity; i++) {
                System.out.println((i + 1) + "- " + patients[i].getName());
            }
        }
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

}