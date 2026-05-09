package com.raghul.clinx.features.prescription;

import java.util.List;

public class PrescriptionService {

    private final PrescriptionRepository repository;

    public PrescriptionService() {
        this.repository = new PrescriptionRepository();
    }

    public void addPrescription(String patientName, String doctorName, String notes) {
        repository.addPrescription(patientName, doctorName, notes);
    }

    public List<String> getPrescriptions() {
        return repository.getPrescriptions();
    }
}
