package com.raghul.clinx.services;

import com.raghul.clinx.data.dto.AppointmentDTO;
import com.raghul.clinx.repositories.AppointmentRepository;
import java.util.List;

public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService() {
        this.repository = new AppointmentRepository();
    }

    public AppointmentDTO createAppointment(String patientName, String doctorName, long date, String timeSlot) {
        return repository.createAppointment(patientName, doctorName, date, timeSlot);
    }

    public List<AppointmentDTO> getAppointments() {
        return repository.getAppointments();
    }

    public boolean cancelAppointment(long appointmentId) {
        return repository.cancelAppointment(appointmentId);
    }
}
