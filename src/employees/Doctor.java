package employees;

import medicines.Medicine;

import java.math.BigDecimal;

public class Doctor extends Employee {

    public Doctor(String name, String surname, String position) {
        super(name, surname, position);
    }

    @Override
    public void setPayout(BigDecimal hourly) {
        BigDecimal adjustedPayout = hourly.multiply(BigDecimal.valueOf(1.78));
        System.out.println("employees.Doctor's payout rate adjusted to: " + adjustedPayout);
    }

    // Polymorphic method to prescribe medicine
    public void prescribeMedicine(Medicine medicine) {
        System.out.println("employees.Doctor " + getName() + " " + getSurname() + " is prescribing...");
        System.out.println(medicine.getMedicineDetails());
    }

    // Polymorphic method to administer medicine
    public void administerMedicine(Medicine medicine) {
        System.out.println("employees.Doctor " + getName() + " " + getSurname() + " is administering...");
        System.out.println(medicine.administer());
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Position: " + position);
        if (address != null) {
            System.out.println("basicInformation.Address: " + address);
        }
        if (hourly != null) {
            System.out.println("Hourly Rate: " + hourly);
        }
    }
}