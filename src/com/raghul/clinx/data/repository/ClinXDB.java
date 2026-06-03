package com.raghul.clinx.data.repository;

import com.raghul.clinx.data.dto.AppointmentDTO;
import com.raghul.clinx.data.dto.DoctorDetailDTO;
import com.raghul.clinx.data.dto.InvoiceDTO;
import com.raghul.clinx.data.dto.UserDTO;
import com.raghul.clinx.security.PasswordHasher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClinXDB {

	private static final List<UserDTO> users = new ArrayList<>();
	private static final Map<String, String> passwordHashes = new HashMap<>();
	private static final List<DoctorDetailDTO> doctors = new ArrayList<>();
	private static final List<String> patients = new ArrayList<>();
	private static final List<AppointmentDTO> appointments = new ArrayList<>();
	private static final List<InvoiceDTO> invoices = new ArrayList<>();
	private static final List<String> prescriptions = new ArrayList<>();

	private static long userIdSeq = 1;
	private static long doctorIdSeq = 1;
	private static long appointmentIdSeq = 1;
	private static long invoiceIdSeq = 1;

	static {
		UserDTO admin = new UserDTO(nextUserId(), "Admin", "admin@clinx.com", "ADMIN", System.currentTimeMillis());
		users.add(admin);
		passwordHashes.put(admin.getEmail(), PasswordHasher.hash("admin123"));
	}

	public static long nextUserId() {
		return userIdSeq++;
	}

	public static long nextDoctorId() {
		return doctorIdSeq++;
	}

	public static long nextAppointmentId() {
		return appointmentIdSeq++;
	}

	public static long nextInvoiceId() {
		return invoiceIdSeq++;
	}

	public static void addUser(UserDTO user, String passwordHash) {
		users.add(user);
		passwordHashes.put(normalizeEmail(user.getEmail()), passwordHash);
	}

	public static UserDTO getUserByEmail(String email) {
		for (UserDTO user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}

	public static String getPasswordHash(String email) {
		return passwordHashes.get(normalizeEmail(email));
	}

	private static String normalizeEmail(String email) {
		return email == null ? null : email.trim().toLowerCase();
	}

	public static List<UserDTO> getUsers() {
		return users;
	}

	public static void addDoctor(DoctorDetailDTO doctor) {
		doctors.add(doctor);
	}

	public static List<DoctorDetailDTO> getDoctors() {
		return doctors;
	}

	public static boolean removeDoctor(long doctorId) {
		return doctors.removeIf(doc -> doc.getDoctorId() == doctorId);
	}

	public static void addPatient(String name) {
		patients.add(name);
	}

	public static List<String> getPatients() {
		return patients;
	}

	public static boolean removePatient(String name) {
		return patients.removeIf(p -> p.equalsIgnoreCase(name));
	}

	public static void addAppointment(AppointmentDTO appointment) {
		appointments.add(appointment);
	}

	public static List<AppointmentDTO> getAppointments() {
		return appointments;
	}

	public static AppointmentDTO findAppointment(long appointmentId) {
		for (AppointmentDTO appointment : appointments) {
			if (appointment.getAppointmentId() == appointmentId) {
				return appointment;
			}
		}
		return null;
	}

	public static boolean removeAppointment(long appointmentId) {
		return appointments.removeIf(app -> app.getAppointmentId() == appointmentId);
	}

	public static void addInvoice(InvoiceDTO invoice) {
		invoices.add(invoice);
	}

	public static List<InvoiceDTO> getInvoices() {
		return invoices;
	}

	public static InvoiceDTO findInvoice(long invoiceId) {
		for (InvoiceDTO invoice : invoices) {
			if (invoice.getInvoiceId() == invoiceId) {
				return invoice;
			}
		}
		return null;
	}

	public static void addPrescription(String prescription) {
		prescriptions.add(prescription);
	}

	public static List<String> getPrescriptions() {
		return prescriptions;
	}
}
