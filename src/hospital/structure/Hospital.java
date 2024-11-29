package hospital.structure;

import basicInformation.Address;
import interfaces.SerializableNo;


public final class Hospital {

    public static int currentPatients; // Static variable - shared among all instances

    static {
        currentPatients = 0; // initializing before class is made and called
    }

    private String name;
    private Department[] departments;
    private Branch[] branches;
    private Address address;

    public static void CurrentVacancy() {

        System.out.println("Current patients: " + currentPatients);
    }

    // Method that accepts any object implementing SerializableNo
    public static void displaySerialInfo(SerializableNo item) {
        System.out.println("Serial Number: " + item.getSerialNumber());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Branch[] getBranches() {
        return branches;
    }

    public void setBranches(Branch[] branches) {
        this.branches = branches;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}