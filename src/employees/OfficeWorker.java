package employees;

public class OfficeWorker extends Employee {

    public OfficeWorker(String name, String surname, String position) {
        super(name, surname, position);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Position: " + position);
    }

}


