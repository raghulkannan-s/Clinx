package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.LoginRequest;
import com.raghul.clinx.security.PasswordHasher;

public class AuthService {

    private final AuthRepository repository;

    public AuthService() {
        this.repository = new AuthRepository();
    }

    public boolean authenticate(LoginRequest request) {
        String storedHash = repository.getPasswordHash(request.getEmail());
        if (storedHash == null) {
            return false;
        }
        return PasswordHasher.matches(request.getPassword(), storedHash);
    }
}
