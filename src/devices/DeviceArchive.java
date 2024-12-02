package devices;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DeviceArchive implements AutoCloseable {

    private final BufferedWriter writer;

    // Constructor to initialize the BufferedWriter for the specified file
    public DeviceArchive(String filePath) throws IOException {
        writer = new BufferedWriter(new FileWriter(filePath, true));
    }

    // Method to save a list of devices to the file
    public void saveDevices(List<Device> devices) throws IOException, SerialException {
        for (Device device : devices) {
            writer.write("Device Name: " + device.getName());
            writer.newLine();
            writer.write("Serial Number: " + device.getSerialNumber());
            writer.newLine();
            writer.write("------------");
            writer.newLine();
        }
        System.out.println("Devices saved successfully.");
    }

    @Override
    public void close() throws IOException {
        try {
            writer.close();
            System.out.println("DeviceSaver closed successfully.");
        } catch (IOException e) {
            System.out.println("Error closing DeviceSaver: " + e.getMessage());
        }
    }
}
