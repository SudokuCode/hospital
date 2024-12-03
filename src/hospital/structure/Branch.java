package hospital.structure;

import employees.Doctor;
import interfaces.CapacityManager;
import interfaces.Registrable;
import patients.Patient;

import java.util.ArrayList;
import java.util.List;

public abstract class Branch implements CapacityManager, Registrable {

    protected String name;
    protected List<Doctor> doctors = new ArrayList<>();
    protected int currentCapacity = 0;
    protected int maxCapacity;
    protected List<Patient> patients = new ArrayList<>();

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int capacity) {
        if (capacity < currentCapacity)
            throw new CapacityException("The maximum capacity is reached !!! ");
        this.maxCapacity = capacity;
    }

    @Override
    public boolean canRegister() {
        return currentCapacity < maxCapacity;
    }

    public void addPatient(Patient patient) {
        if (!canRegister()) {
            throw new CapacityException(" Cannot add more patients, please check maximum Branch capacity.");
        }
        patients.add(patient);
        patients.set(currentCapacity, patient);
        currentCapacity++; // counts beds which are used in a branch
        Hospital.currentPatients++; // counts all patients in hospital
    }

    public void showPatients() {
        if (currentCapacity == 0) {
            System.out.println("No patients in " + name);
        } else {
            for (int i = 0; i < currentCapacity; i++) {
                System.out.println((i + 1) + "- " + patients.get(i).getName());
            }
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}