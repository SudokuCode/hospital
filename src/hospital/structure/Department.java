package hospital.structure;

import employees.Employee;
import interfaces.CapacityManager;
import interfaces.Registrable;

import java.util.ArrayList;
import java.util.List;


public abstract class Department implements CapacityManager, Registrable {

    protected List<Employee> employees = new ArrayList<>();

    public abstract void addEmployee(Employee employee);

    public void showEmployees() {
        if (employees != null) {
            System.out.println("Employees in department: ");
            for (Employee employee : employees) System.out.println("- " + employee.getName());
        } else {
            System.out.println("No employee assigned to this department.");
        }
    }
}