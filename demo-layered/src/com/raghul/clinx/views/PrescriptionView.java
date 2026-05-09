package com.raghul.clinx.views;

import com.raghul.clinx.services.PrescriptionService;
import java.util.List;
import java.util.Scanner;

public class PrescriptionView {

	private final PrescriptionService service;
	private final Scanner scanner;

	public PrescriptionView(Scanner scanner) {
		this.service = new PrescriptionService();
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("\n=== Prescription Menu ===");
			System.out.println("1. Add Prescription");
			System.out.println("2. List Prescriptions");
			System.out.println("0. Back");
			int choice = readInt("Choose: ");

			switch (choice) {
				case 1:
					addPrescription();
					break;
				case 2:
					listPrescriptions();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void addPrescription() {
		System.out.print("Patient name: ");
		String patientName = scanner.nextLine().trim();
		System.out.print("Doctor name: ");
		String doctorName = scanner.nextLine().trim();
		System.out.print("Notes: ");
		String notes = scanner.nextLine().trim();
		service.addPrescription(patientName, doctorName, notes);
		System.out.println("Prescription added.");
	}

	private void listPrescriptions() {
		List<String> prescriptions = service.getPrescriptions();
		if (prescriptions.isEmpty()) {
			System.out.println("No prescriptions available.");
			return;
		}
		for (String entry : prescriptions) {
			System.out.println(entry);
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
