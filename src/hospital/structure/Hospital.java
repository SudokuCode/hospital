package hospital.structure;

import basicInformation.Address;
import devices.SerialException;
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
        try {
            System.out.println("Serial Number: " + item.getSerialNumber());
        } catch (SerialException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() throws HospitalException {
        if (departments == null) {
            throw new HospitalException("Departments have not been initialized");
        }
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Branch[] getBranches() throws HospitalException {
        if (branches == null) {
            throw new HospitalException("Branches have not been initialized");
        }
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