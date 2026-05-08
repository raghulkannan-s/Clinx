package com.raghul.clinx.data.dto;

public class DoctorDetailDTO {
    private Long doctorId;
    private String name;
    private String specialization;
    private Double consultationFee;
    private Integer experience;

    public DoctorDetailDTO(Long doctorId, String name, String specialization, Double consultationFee, Integer experience) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.experience = experience;
    }


    public Long getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public Double getConsultationFee() { return consultationFee; }
    public Integer getExperience() { return experience; }
}