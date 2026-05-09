package com.raghul.clinx.views;

import com.raghul.clinx.data.dto.AppointmentDTO;
import com.raghul.clinx.services.AppointmentService;
import java.util.List;
import java.util.Scanner;

public class AppointmentView {

	private final AppointmentService service;
	private final Scanner scanner;

	public AppointmentView(Scanner scanner) {
		this.service = new AppointmentService();
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("\n=== Appointment Menu ===");
			System.out.println("1. Create Appointment");
			System.out.println("2. List Appointments");
			System.out.println("3. Cancel Appointment");
			System.out.println("0. Back");
			int choice = readInt("Choose: ");

			switch (choice) {
				case 1:
					createAppointment();
					break;
				case 2:
					listAppointments();
					break;
				case 3:
					cancelAppointment();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void createAppointment() {
		System.out.print("Patient name: ");
		String patientName = scanner.nextLine().trim();
		System.out.print("Doctor name: ");
		String doctorName = scanner.nextLine().trim();
		long date = readLong("Appointment date (yyyymmdd): ");
		System.out.print("Time slot (e.g., 10:00-10:30): ");
		String timeSlot = scanner.nextLine().trim();

		AppointmentDTO appointment = service.createAppointment(patientName, doctorName, date, timeSlot);
		System.out.println("Appointment created with ID: " + appointment.getAppointmentId());
	}

	private void listAppointments() {
		List<AppointmentDTO> appointments = service.getAppointments();
		if (appointments.isEmpty()) {
			System.out.println("No appointments available.");
			return;
		}
		for (AppointmentDTO appointment : appointments) {
			System.out.println(appointment.getAppointmentId() + " | " + appointment.getPatientName() + " | "
					+ appointment.getDoctorName() + " | " + appointment.getAppointmentDate() + " | "
					+ appointment.getTimeSlot() + " | " + appointment.getStatus());
		}
	}

	private void cancelAppointment() {
		long id = readLong("Appointment ID to cancel: ");
		boolean removed = service.cancelAppointment(id);
		System.out.println(removed ? "Appointment cancelled." : "Appointment not found.");
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
}
