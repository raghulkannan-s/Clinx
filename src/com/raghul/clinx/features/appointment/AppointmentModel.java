package com.raghul.clinx.features.appointment;

import com.raghul.clinx.data.dto.AppointmentDTO;
import com.raghul.clinx.data.repository.ClinXDB;
import java.util.List;

public class AppointmentModel {

	public AppointmentDTO createAppointment(String patientName, String doctorName, long date, String timeSlot) {
		AppointmentDTO appointment = new AppointmentDTO(
				ClinXDB.nextAppointmentId(),
				patientName,
				doctorName,
				date,
				timeSlot,
				"Scheduled"
		);
		ClinXDB.addAppointment(appointment);
		return appointment;
	}

	public List<AppointmentDTO> getAppointments() {
		return ClinXDB.getAppointments();
	}

	public boolean cancelAppointment(long appointmentId) {
		return ClinXDB.removeAppointment(appointmentId);
	}
}
