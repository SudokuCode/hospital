package employees;

import basicInformation.Address;
import interfaces.Display;

import java.math.BigDecimal;

public abstract class Employee implements Display {

    protected String name;
    protected String surname;
    protected Address address;
    protected String position;
    protected BigDecimal hourly;

    public Employee(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    @Override
    public void displayInfo() {
        System.out.println(getName() + " " + getSurname());
        System.out.println(getPosition());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getPayout() {
        return hourly;
    }

    public void setPayout(BigDecimal hourly) {
        this.hourly = hourly;
    }
}
