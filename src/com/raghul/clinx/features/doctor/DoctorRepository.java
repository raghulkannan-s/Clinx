package com.raghul.clinx.features.doctor;

import com.raghul.clinx.data.dto.DoctorDetailDTO;
import com.raghul.clinx.data.repository.ClinXDB;
import java.util.List;

public class DoctorRepository {

    public DoctorDetailDTO addDoctor(String name, String specialization, double fee, int experience) {
        DoctorDetailDTO doctor = new DoctorDetailDTO(ClinXDB.nextDoctorId(), name, specialization, fee, experience);
        ClinXDB.addDoctor(doctor);
        return doctor;
    }

    public List<DoctorDetailDTO> getDoctors() {
        return ClinXDB.getDoctors();
    }

    public boolean removeDoctor(long doctorId) {
        return ClinXDB.removeDoctor(doctorId);
    }
}
