package medicines;

import java.time.LocalDateTime;

public final class Antibiotic extends Medicine {

    private final String prescription;
    private final LocalDateTime dateOfFinalUse;

    public Antibiotic(String name, double dose, String prescription, LocalDateTime dateOfFinalUse) {
        super(name, dose);
        this.prescription = prescription;
        this.dateOfFinalUse = dateOfFinalUse;
    }

    public String getPrescription() {
        return prescription;
    }

    public LocalDateTime getDateOfFinalUse() {
        return dateOfFinalUse;
    }

    @Override
    public String getMedicineDetails() {
        return "medicines.Antibiotic: " + getName() + ". Prescription: " + prescription + ". Use before: " + dateOfFinalUse;
    }

    @Override
    public String administer() {
        return "Administering antibiotic: " + getName() + ". Follow prescription carefully.";
    }
}

