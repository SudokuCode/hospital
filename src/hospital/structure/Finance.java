package hospital.structure;

import employees.Employee;
import employees.OfficeWorker;

import java.time.LocalDate;
import java.util.List;

public class Finance extends Department {

    private LocalDate date;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
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
            if (employee instanceof OfficeWorker) {
                employees.add(employee);
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

        return employees.size() < getMaxCapacity();
    }

    @Override
    public int getMaxCapacity() {
        return 4;
    }
}