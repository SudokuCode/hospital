import basicInformation.Address;
import employees.Doctor;
import employees.OfficeWorker;
import hospital.structure.*;
import medicines.Antibiotic;
import medicines.Antihistamine;
import medicines.Medicine;
import medicines.MedicineService;
import patients.Patient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

/* TODO list :
Create 5 custom exceptions (checked and unchecked) and use them in your program
Handle exceptions (using throws and try-catch-finally)
Use try-catch with resources (create at least one class that implements the AutoCloseable interface and close it using the try with resources
and use at least one class built into Java that implements this interface, and close it as well) */

public class Main {

    public static void main(String[] args) {

        Reception reception = new Reception();
        Finance finance = new Finance();
        Pulmonology pulmonology = new Pulmonology();
        Neurology neurology = new Neurology();
        Patient patient1 = new Patient("Mat", "Cat");
        Patient patient2 = new Patient("John", "Wick");
        Address hospitalAddress = new Address("Jagiellonska", 123, "Warszawa", "00-230");
        Hospital hospital = new Hospital();
        hospital.setName("St.Joseph");
        hospital.setDepartments(new Department[]{reception});
        hospital.setDepartments(new Department[]{finance});
        hospital.setBranches(new Branch[]{pulmonology, neurology});
        hospital.setAddress(hospitalAddress);
        System.out.println(Arrays.toString(hospital.getBranches()));

        reception.register(patient1, neurology);
        System.out.println(reception.register(patient2, neurology));
        reception.showPatient(pulmonology);
        reception.showPatient(neurology);
        System.out.println(hospitalAddress);

        OfficeWorker receptionist = new OfficeWorker("Ann", "Lee", "receptionist");
        OfficeWorker receptionist2 = new OfficeWorker("Jack", "Two", "receptionist");
        OfficeWorker financist = new OfficeWorker("Kate", "Winslet", "financist");
        OfficeWorker financist2 = new OfficeWorker("X", "x", "r");
        Doctor firstd = new Doctor("John", "Smith", "neurologist");
        Doctor secondd = new Doctor("Adam", "Waltz", "pulmonologist");
        firstd.setPayout(BigDecimal.valueOf(34.5));
        financist.setPayout(BigDecimal.valueOf(34.6));

        reception.addEmployee(receptionist);
        reception.addEmployee(receptionist2);
        reception.showEmployees();
        finance.addEmployee(financist);
        finance.addEmployee(financist2);
        finance.showEmployees();
        financist.displayInfo();
        receptionist.displayInfo();
        Medicine painkiller = new Medicine("Paracetamol", 110.75);
        Medicine antibiotic = new Antibiotic("Amoxicillin", 250.75, "Take with food", LocalDateTime.now().plusDays(7));
        Medicine antihistamine = new Antihistamine("Cetirizine", 150.75, "Avoid alcohol", LocalDateTime.now().plusDays(14));
        firstd.prescribeMedicine(painkiller); // General medicine behavior
        firstd.prescribeMedicine(antibiotic); // medicines.Antibiotic-specific behavior
        firstd.prescribeMedicine(antihistamine); // medicines.Antihistamine-specific behavior
        // Administer medicines using polymorphism
        firstd.administerMedicine(painkiller); // General medicine behavior
        firstd.administerMedicine(antibiotic); // medicines.Antibiotic-specific behavior
        firstd.administerMedicine(antihistamine);
        System.out.println(painkiller);
        System.out.println(antibiotic);
        System.out.println("Are the medicines equal? " + antibiotic.equals(painkiller)); // compare if antibiotic reference is equal to painkiller
        // - does it refer to the same object
        System.out.println("Painkiller HashCode: " + painkiller.hashCode());
        System.out.println("medicines.Antibiotic HashCode: " + antibiotic.hashCode());
        Hospital.CurrentVacancy();
        firstd.show();
        secondd.show();
        financist.show();
        System.out.println(MedicineService.usageType(painkiller));
        System.out.println(MedicineService.usageType(antibiotic));
        System.out.println(MedicineService.usageType(antihistamine));
    }
}