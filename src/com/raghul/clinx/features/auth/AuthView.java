package com.raghul.clinx.features.auth;

import com.raghul.clinx.data.dto.LoginRequest;
import java.util.Scanner;

public class AuthView {

    private static final String[] ROLES = {"ADMIN", "DOCTOR", "STAFF"};

	private final AuthService service;
	private final Scanner scanner;

	public AuthView(Scanner scanner) {
		this.service = new AuthService();
		this.scanner = scanner;
	}

	public boolean start() {
		while (true) {
			System.out.println("=== ClinX Auth ===");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			System.out.print("Choose: ");
			String choice = scanner.nextLine().trim();

			switch (choice) {
				case "1":
					return login();
				case "2":
					register();
					break;
				case "0":
					return false;
				default:
					System.out.println("Invalid choice.\n");
			}
		}
	}

	private boolean login() {
		System.out.println("=== ClinX Login ===");
		for (int attempt = 1; attempt <= 3; attempt++) {
			String email = readEmail("Email: ");
			String password = readPassword("Password: ");

			LoginRequest request = new LoginRequest(email, password);
			if (service.authenticate(request)) {
				System.out.println("Login successful.\n");
				return true;
			}
			System.out.println("Invalid credentials. Attempts left: " + (3 - attempt));
		}

		System.out.println("Too many failed attempts. Exiting.");
		return false;
	}

	private void register() {
		System.out.println("=== ClinX Registration ===");
		String name = readRequired("Full name: ");
		String email = readEmail("Email: ");
		String role = readRole("Role (ADMIN/DOCTOR/STAFF): ");
		String password = readPasswordWithConfirm("Password: ", "Confirm password: ");

		boolean created = service.register(name, email, role, password);
		if (created) {
			System.out.println("Registration successful. Please log in.\n");
		} else {
			System.out.println("Email already registered. Try logging in.\n");
		}
	}

	private String readRequired(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim();
			if (!value.isEmpty()) {
				return value;
			}
			System.out.println("This field is required.");
		}
	}

	private String readEmail(String prompt) {
		while (true) {
			String email = readRequired(prompt);
			if (isValidEmail(email)) {
				return email;
			}
			System.out.println("Enter a valid email address.");
		}
	}

	private String readPassword(String prompt) {
		while (true) {
			System.out.print(prompt);
			String password = scanner.nextLine();
			if (password.length() >= 6) {
				return password;
			}
			System.out.println("Password must be at least 6 characters.");
		}
	}

	private String readPasswordWithConfirm(String prompt, String confirmPrompt) {
		while (true) {
			String password = readPassword(prompt);
			System.out.print(confirmPrompt);
			String confirm = scanner.nextLine();
			if (password.equals(confirm)) {
				return password;
			}
			System.out.println("Passwords do not match.");
		}
	}

	private String readRole(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim().toUpperCase();
			for (String role : ROLES) {
				if (role.equals(value)) {
					return value;
				}
			}
			System.out.println("Allowed roles: ADMIN, DOCTOR, STAFF.");
		}
	}

	private boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".") && !email.startsWith("@") && !email.endsWith(".");
	}
}
