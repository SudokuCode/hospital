package devices;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceArchive implements AutoCloseable {

    private final BufferedWriter writer;

    // Constructor to initialize the BufferedWriter for the specified file
    public DeviceArchive(String filePath) throws IOException {
        writer = new BufferedWriter(new FileWriter(filePath, true));
    }

    // Method to save a list of devices to the file
    public void saveDevices(List<Device> devices) throws IOException, SerialException {
        Set<String> serials = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("devices.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Serial Number: ")) {
                    String existingSN = line.substring(15);
                    serials.add(existingSN);
                }
            }
        }
        for (Device device : devices) {
            String serial = device.getSerialNumber();
            if (serials.contains(serial)) {
                System.out.println("Device already in file , serialNO : " + serial);
                continue;
            }
            writer.write("Device Name: " + device.getName());
            writer.newLine();
            writer.write("Serial Number: " + device.getSerialNumber());
            writer.newLine();
            writer.write("------------");
            writer.newLine();
            serials.add(serial);
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
