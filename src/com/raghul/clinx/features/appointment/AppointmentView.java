package com.raghul.clinx.features.appointment;

import com.raghul.clinx.data.dto.AppointmentDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
		String patientName = readRequired("Patient name: ");
		String doctorName = readRequired("Doctor name: ");
		long date = readDate("Appointment date (yyyymmdd): ");
		String timeSlot = readRequired("Time slot (e.g., 10:00-10:30): ");

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

	private long readDate(String prompt) {
		while (true) {
			String value = readRequired(prompt);
			try {
				LocalDate.parse(value, DateTimeFormatter.BASIC_ISO_DATE);
				return Long.parseLong(value);
			} catch (DateTimeParseException ex) {
				System.out.println("Enter date as 8 digits in yyyymmdd format.");
			}
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
}
