package com.raghul.clinx.features.patient;

import java.util.List;

public class PatientService {

    private final PatientRepository repository;

    public PatientService() {
        this.repository = new PatientRepository();
    }

    public void addPatient(String name) {
        repository.addPatient(name);
    }

    public List<String> getPatients() {
        return repository.getPatients();
    }

    public boolean removePatient(String name) {
        return repository.removePatient(name);
    }
}
