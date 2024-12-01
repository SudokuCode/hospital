package patients;

import java.io.*;

public final class MedicalHistory {

    private static final String DIRECTORY_PATH = "D:\\tools\\intelij-workspace\\hospital MedicalHistory";
    private final File file;

    // Constructor that initializes the file object and creates the file if it doesn't exist
    public MedicalHistory(String fileName) {
        file = new File(DIRECTORY_PATH, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file " + fileName + ".");
        }
    }

    public void writeMedicalHistory(Patient patient, String history) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Patient: " + patient.getName() + " " + patient.getSurname());
            writer.newLine();
            writer.write("History: " + history);
            writer.newLine();
            writer.write("------------");
            writer.newLine();
            System.out.println("Medical history written for " + patient.getName());
            System.out.println(" ");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing medical history: " + e.getMessage());
            System.out.println(" ");
        }
    }

    public void readMedicalHistory() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading medical history: " + e.getMessage());
        }
    }

    public File getFile() {
        return file;
    }
}
