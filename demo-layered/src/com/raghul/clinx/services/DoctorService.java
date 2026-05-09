package com.raghul.clinx.services;

import com.raghul.clinx.data.dto.DoctorDetailDTO;
import com.raghul.clinx.repositories.DoctorRepository;
import java.util.List;

public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService() {
        this.repository = new DoctorRepository();
    }

    public DoctorDetailDTO addDoctor(String name, String specialization, double fee, int experience) {
        return repository.addDoctor(name, specialization, fee, experience);
    }

    public List<DoctorDetailDTO> getDoctors() {
        return repository.getDoctors();
    }

    public boolean removeDoctor(long doctorId) {
        return repository.removeDoctor(doctorId);
    }
}
