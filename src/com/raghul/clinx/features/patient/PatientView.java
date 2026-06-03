package com.raghul.clinx.features.patient;

import java.util.List;
import java.util.Scanner;

public class PatientView {

	private final PatientService service;
	private final Scanner scanner;

	public PatientView(Scanner scanner) {
		this.service = new PatientService();
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("\n=== Patient Menu ===");
			System.out.println("1. Add Patient");
			System.out.println("2. List Patients");
			System.out.println("3. Remove Patient");
			System.out.println("0. Back");
			int choice = readInt("Choose: ");

			switch (choice) {
				case 1:
					addPatient();
					break;
				case 2:
					listPatients();
					break;
				case 3:
					removePatient();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void addPatient() {
		String name = readRequired("Patient name: ");
		service.addPatient(name);
		System.out.println("Patient added.");
	}

	private void listPatients() {
		List<String> patients = service.getPatients();
		if (patients.isEmpty()) {
			System.out.println("No patients available.");
			return;
		}
		for (String name : patients) {
			System.out.println("- " + name);
		}
	}

	private void removePatient() {
		String name = readRequired("Patient name to remove: ");
		boolean removed = service.removePatient(name);
		System.out.println(removed ? "Patient removed." : "Patient not found.");
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

	private int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim();
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				System.out.println("Enter a valid number.");
			}
		}
	}
}
