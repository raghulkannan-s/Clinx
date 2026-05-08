package com.raghul.clinx.features.prescription;

import com.raghul.clinx.data.repository.ClinXDB;
import java.util.List;

public class PrescriptionModel {

	public void addPrescription(String patientName, String doctorName, String notes) {
		String entry = patientName + " | " + doctorName + " | " + notes;
		ClinXDB.addPrescription(entry);
	}

	public List<String> getPrescriptions() {
		return ClinXDB.getPrescriptions();
	}
}
