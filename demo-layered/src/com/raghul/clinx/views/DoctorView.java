package com.raghul.clinx.views;

import com.raghul.clinx.data.dto.DoctorDetailDTO;
import com.raghul.clinx.services.DoctorService;
import java.util.List;
import java.util.Scanner;

public class DoctorView {

	private final DoctorService service;
	private final Scanner scanner;

	public DoctorView(Scanner scanner) {
		this.service = new DoctorService();
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("\n=== Doctor Menu ===");
			System.out.println("1. Add Doctor");
			System.out.println("2. List Doctors");
			System.out.println("3. Remove Doctor");
			System.out.println("0. Back");
			int choice = readInt("Choose: ");

			switch (choice) {
				case 1:
					addDoctor();
					break;
				case 2:
					listDoctors();
					break;
				case 3:
					removeDoctor();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void addDoctor() {
		System.out.print("Name: ");
		String name = scanner.nextLine().trim();
		System.out.print("Specialization: ");
		String specialization = scanner.nextLine().trim();
		double fee = readDouble("Consultation fee: ");
		int experience = readInt("Experience (years): ");

		DoctorDetailDTO doctor = service.addDoctor(name, specialization, fee, experience);
		System.out.println("Doctor added with ID: " + doctor.getDoctorId());
	}

	private void listDoctors() {
		List<DoctorDetailDTO> doctors = service.getDoctors();
		if (doctors.isEmpty()) {
			System.out.println("No doctors available.");
			return;
		}
		for (DoctorDetailDTO doctor : doctors) {
			System.out.println(doctor.getDoctorId() + " | " + doctor.getName() + " | " + doctor.getSpecialization()
					+ " | Fee: " + doctor.getConsultationFee() + " | Exp: " + doctor.getExperience());
		}
	}

	private void removeDoctor() {
		long id = readLong("Doctor ID to remove: ");
		boolean removed = service.removeDoctor(id);
		System.out.println(removed ? "Doctor removed." : "Doctor not found.");
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

	private long readLong(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim();
			try {
				return Long.parseLong(value);
			} catch (NumberFormatException ex) {
				System.out.println("Enter a valid number.");
			}
		}
	}

	private double readDouble(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim();
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException ex) {
				System.out.println("Enter a valid amount.");
			}
		}
	}
}
