package com.raghul.clinx.data.dto;

public class AppointmentDTO {
    private Long appointmentId;
    private String patientName;
    private String doctorName;
    private Long appointmentDate;
    private String timeSlot;
    private String status;

    public AppointmentDTO(Long appointmentId, String patientName, String doctorName, Long appointmentDate, String timeSlot, String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public Long getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public Long getAppointmentDate() { return appointmentDate; }
    public String getTimeSlot() { return timeSlot; }
    public String getStatus() { return status; }
}