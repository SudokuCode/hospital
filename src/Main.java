import basicInformation.Address;
import devices.Device;
import devices.DeviceArchive;
import employees.Doctor;
import employees.OfficeWorker;
import hospital.structure.*;
import medicines.Antibiotic;
import medicines.Antihistamine;
import medicines.Medicine;
import medicines.MedicineService;
import patients.MedicalHistory;
import patients.Patient;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* TODO list :
Create 5 custom exceptions (checked and unchecked) and use them in your program
Handle exceptions (using throws and try-catch-finally)

Update all arrays with collections (your project must have at least 5 collections - at least one List, one Set and one Map)

(optional) Create custom LinkedList class with generic. (this class must implement the List interface)*/

public class Main {

    public static void main(String[] args) throws IOException {

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
        System.out.println("Displaying Medicine Serial Numbers:");
        Hospital.displaySerialInfo(antihistamine);
        Hospital.displaySerialInfo(antibiotic);
        Device device1 = new Device("Laptop");
        Device device2 = new Device("Printer");
        Device device3 = new Device("Monitor");
        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        devices.add(device3);
        try (DeviceArchive archive = new DeviceArchive("devices.txt")) {
            archive.saveDevices(devices);  // Save devices to the file
        } catch (IOException e) {
            System.out.println("Error saving devices: " + e.getMessage());

            System.out.println("\nDisplaying Device Serial Numbers:");
            Hospital.displaySerialInfo(device1);
            Hospital.displaySerialInfo(device2);
            Hospital.displaySerialInfo(device3);
            patient1.treatmentProgram();
            patient2.medicineSlot();
            MedicalHistory patient1history = new MedicalHistory("patient1.txt");
            patient1history.writeMedicalHistory(patient1, "Dose of the medicine applied : 32");
            patient1history.readMedicalHistory();

        }
    }
}



