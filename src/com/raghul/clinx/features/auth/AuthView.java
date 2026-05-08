package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.LoginRequest;
import java.util.Scanner;

public class AuthView {

	private final AuthModel model;
	private final Scanner scanner;

	public AuthView(Scanner scanner) {
		this.model = new AuthModel();
		this.scanner = scanner;
	}

	public boolean login() {
		System.out.println("=== ClinX Login ===");
		for (int attempt = 1; attempt <= 3; attempt++) {
			System.out.print("Email: ");
			String email = scanner.nextLine().trim();
			System.out.print("Password: ");
			String password = scanner.nextLine().trim();

			LoginRequest request = new LoginRequest(email, password);
			if (model.authenticate(request)) {
				System.out.println("Login successful.\n");
				return true;
			}
			System.out.println("Invalid credentials. Attempts left: " + (3 - attempt));
		}

		System.out.println("Too many failed attempts. Exiting.");
		return false;
	}
}
