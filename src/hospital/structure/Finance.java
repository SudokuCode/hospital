package hospital.structure;

import employees.Employee;
import employees.OfficeWorker;

import java.time.LocalDate;
import java.util.Arrays;

public class Finance extends Department {

    private LocalDate date;

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(OfficeWorker[] employees) {
        this.employees = employees;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (canRegister()) {
            this.employees = Arrays.copyOf(this.employees, this.employees.length + 1);
            if (employee instanceof OfficeWorker) {
                this.employees[this.employees.length - 1] = employee;
            } else {
                System.out.println("Only OfficeWorkers can be added to Finance.");
            }
            System.out.println("Employee added to Finance");
        } else {
            System.out.println(" ! Maximum capacity reached");
        }
    }

    @Override
    public boolean canRegister() {

        return employees.length < getMaxCapacity();
    }

    @Override
    public int getMaxCapacity() {
        return 4;
    }
}