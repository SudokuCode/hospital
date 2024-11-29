package devices;

import interfaces.SerializableNo;

public class Device implements SerializableNo {

    private static int counter = 0;
    private final String serialNo;
    private String name;

    public Device(String name) {
        this.name = name;
        counter++;
        this.serialNo = "DS" + String.format("%05d", counter);
    }

    @Override
    public String getSerialNumber() {
        return serialNo;
    }

    public String getName() {
        return name;
    }
}

