import basicInformation.Address;
import basicInformation.AddressException;
import devices.Device;
import devices.DeviceArchive;
import devices.SerialException;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
TODO list :
MedicineService - 'if' statement can be replaced with 'switch' statement
Patient - Variable 'timeSlots' is never used
Reception - Parameter 'date' is never used
DeviceArchive - Exception 'java.io.IOException' is never thrown in the method
(optional) Create custom LinkedList class with generic. (this class must implement the List interface)
Move your project to Maven.
Build jar file using Maven and deploy to the local repository. (local repository is ".m2" folder
 - deploy using "install" command)
Run mvn for different phases from the Maven lifecycle. Check the result.
Read text from the file (download any online book or article in txt format and move it to resources folder)
and calculate the numbers of the unique words. Write the result to the file.
The main requirement is:
using StringUtils and FileUtils (from Apache libraries) to implement it with minimum lines of code.
Replace all the "System.out.println" with Logger. Your loggers should log in two places - in the console and in a file
 */

public class Main {

    public static void main(String[] args) throws AddressException {

        Reception reception = new Reception();
        Finance finance = new Finance();
        Pulmonology pulmonology = new Pulmonology();
        Neurology neurology = new Neurology();
        Patient patient1 = new Patient("Mat", "Cat");
        Patient patient2 = new Patient("John", "Wick");
        Patient patient3 = new Patient();
        Address hospitalAddress = new Address("Jagiellonska", 123, "Warszawa", "00-230");
        Hospital hospital = new Hospital();
        hospital.setName("St.Joseph");
        hospital.setDepartments(List.of(new Department[]{reception}));
        hospital.setDepartments(List.of(new Department[]{finance}));
        hospital.setBranches(List.of(new Branch[]{pulmonology, neurology}));
        pulmonology.setMaxCapacity(2);
        hospital.setAddress(hospitalAddress);
        Hospital hospitalTest = new Hospital();
        try {
            hospitalTest.getBranches();
        } catch (HospitalException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            System.out.println((hospital.getBranches()));
        } catch (HospitalException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Branches should be declared following the Branch rules");
        }

        reception.register(patient1, neurology);
        reception.register(patient2, pulmonology);
        reception.register(patient3, pulmonology);
        System.out.println(reception.register(patient2, neurology));
        System.out.println(reception.register(patient3, pulmonology));
        reception.showPatient(pulmonology);
        reception.showPatient(neurology);
        System.out.println(hospitalAddress);
        try {
            pulmonology.addPatient(new Patient("Emily", "Brown"));

        } catch (CapacityException e) {
            System.out.println("Branch excetption cought! ->" + e.getMessage());
        }

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
        Set<Device> devices = new HashSet<>();
        devices.add(device1);
        devices.add(device2);
        devices.add(device3);
        try (DeviceArchive archive = new DeviceArchive("devices.txt")) {
            archive.saveDevices((Set<Device>) devices);  // Save devices to the file
        } catch (IOException e) {
            System.out.println("Error saving devices: " + e.getMessage());

            System.out.println("\nDisplaying Device Serial Numbers:");
            Hospital.displaySerialInfo(device1);
            Hospital.displaySerialInfo(device2);
            Hospital.displaySerialInfo(device3);
            patient1.treatmentProgram();
            patient2.medicineSlot();
            MedicalHistory patient1history = new MedicalHistory("patient1.txt");
            try {
                patient1history.writeMedicalHistory(patient1, "Dose of the medicine applied : 32");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                patient1history.readMedicalHistory();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SerialException e) {
            throw new RuntimeException(e);
        }
        antibiotic.setStock(10);
        System.out.println("Stock set to: " + antibiotic.getStock());

        pulmonology.addMedicine(painkiller);
        pulmonology.addMedicine(antibiotic);
        pulmonology.showMedicines();
        pulmonology.addMedicine(painkiller);

        // Attempt to set stock to a negative value (throws MedicineException)
        painkiller.setStock(-5);
    }
}



