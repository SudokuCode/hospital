package hospital.structure;

import employees.Employee;
import employees.OfficeWorker;
import patients.Patient;

import java.time.LocalDate;
import java.util.Arrays;

public class Reception extends Department {

    private LocalDate date;

    @Override
    public void addEmployee(Employee employee) {

        if (canRegister()) {
            employees = Arrays.copyOf(employees, employees.length + 1);
            if (employee instanceof OfficeWorker) {
                employees[employees.length - 1] = employee;
            } else {
                System.out.println("Only OfficeWorkers can be added to Reception.");
                return;
            }
            System.out.println("Employee added to Reception");
        } else {
            System.out.println(" ! Max capacity reached");
        }
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now();
    }

    public void showPatient(Branch branch) {
        System.out.println("Patients in " + branch.name + ":");
        branch.showPatients();
    }

    public String register(Patient patient, Branch branch) {
        if (branch.canRegister()) {
            branch.addPatient(patient);
            setDate(date);
            return "Patient " + patient.getName() + " registered successfully at " + date + " in " + branch.name;
        } else {
            return "Patient " + patient.getName() + " Registration on " + date + " failed: " + branch.name.toUpperCase() + " is at full capacity.";
        }
    }

    public OfficeWorker[] getWorkers() {
        return (OfficeWorker[]) employees;
    }

    public void setWorkers(OfficeWorker[] workers) {
        this.employees = workers;
    }

    @Override
    public boolean canRegister() {

        return employees.length < getMaxCapacity();
    }

    @Override
    public int getMaxCapacity() {
        return 3;
    }
}