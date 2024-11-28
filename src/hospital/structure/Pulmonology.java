package hospital.structure;

public class Pulmonology extends Branch {

    public Pulmonology() {
        this.name = "Pulmonology";
        this.maxCapacity = 20;
    }

    @Override
    public void setMaxCapacity(int capacity) {
        super.setMaxCapacity(capacity);
        System.out.println("New max capacity for " + name + ": " + capacity);
    }

}