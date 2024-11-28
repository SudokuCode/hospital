package interfaces;

public interface Display {

    void displayInfo();

    default void show() {
        System.out.println(hashCode());
    }
}


