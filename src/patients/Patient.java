package patients;

import interfaces.Curable;
import medicines.Medicine;

public class Patient implements Curable {

    private final String name;
    private String surname;
    private int age;
    private Medicine medicine;

    public Patient(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public void treatmentProgram() {
        System.out.println("Generating a dynamic treatment plan for: " + name);
    }

    @Override
    public void medicineSlot() {
        System.out.println("Scheduling medicine slots for " + name);
        String[] timeSlots = {"Morning", "Afternoon", "Evening"};
    }
}
