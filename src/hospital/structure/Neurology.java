package hospital.structure;

public class Neurology extends Branch {

    public Neurology() {
        this.name = "Neurology";
        this.maxCapacity = 30;
    }

    @Override
    public void setMaxCapacity(int capacity) {
        super.setMaxCapacity(capacity);
        System.out.println("New max capacity for " + name + ": " + capacity);
    }
}