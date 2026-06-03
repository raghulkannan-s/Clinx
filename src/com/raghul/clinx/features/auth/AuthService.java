package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.LoginRequest;
import com.raghul.clinx.data.dto.UserDTO;
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

    public boolean register(String name, String email, String role, String password) {
        String normalizedEmail = normalizeEmail(email);
        if (repository.getUserByEmail(normalizedEmail) != null) {
            return false;
        }
        UserDTO user = new UserDTO(repository.nextUserId(), name, normalizedEmail, role, System.currentTimeMillis());
        repository.addUser(user, PasswordHasher.hash(password));
        return true;
    }

    private String normalizeEmail(String email) {
        return email == null ? null : email.trim().toLowerCase();
    }
}
