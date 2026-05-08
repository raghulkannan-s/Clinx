package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.LoginRequest;
import com.raghul.clinx.data.repository.ClinXDB;

public class AuthModel {

	public boolean authenticate(LoginRequest request) {
		return ClinXDB.validateCredentials(request.getEmail(), request.getPassword());
	}
}
