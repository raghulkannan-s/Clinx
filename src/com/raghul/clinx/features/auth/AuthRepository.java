package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.UserDTO;
import com.raghul.clinx.data.repository.ClinXDB;

public class AuthRepository {

    public UserDTO getUserByEmail(String email) {
        return ClinXDB.getUserByEmail(email);
    }

    public String getPasswordHash(String email) {
        return ClinXDB.getPasswordHash(email);
    }

    public void addUser(UserDTO user, String passwordHash) {
        ClinXDB.addUser(user, passwordHash);
    }
}
