package com.raghul.clinx.features.patient;

import com.raghul.clinx.data.repository.ClinXDB;
import java.util.List;

public class PatientRepository {

    public void addPatient(String name) {
        ClinXDB.addPatient(name);
    }

    public List<String> getPatients() {
        return ClinXDB.getPatients();
    }

    public boolean removePatient(String name) {
        return ClinXDB.removePatient(name);
    }
}
