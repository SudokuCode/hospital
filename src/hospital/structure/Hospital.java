package hospital.structure;

import basicInformation.Address;

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