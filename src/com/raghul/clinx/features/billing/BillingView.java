package com.raghul.clinx.features.billing;

import com.raghul.clinx.data.dto.InvoiceDTO;
import java.util.List;
import java.util.Scanner;

public class BillingView {

	private final BillingModel model;
	private final Scanner scanner;

	public BillingView(Scanner scanner) {
		this.model = new BillingModel();
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("\n=== Billing Menu ===");
			System.out.println("1. Create Invoice");
			System.out.println("2. List Invoices");
			System.out.println("3. Mark Invoice Paid");
			System.out.println("0. Back");
			int choice = readInt("Choose: ");

			switch (choice) {
				case 1:
					createInvoice();
					break;
				case 2:
					listInvoices();
					break;
				case 3:
					markPaid();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void createInvoice() {
		System.out.print("Patient name: ");
		String patientName = scanner.nextLine().trim();
		System.out.print("Doctor name: ");
		String doctorName = scanner.nextLine().trim();
		double amount = readDouble("Total amount: ");

		InvoiceDTO invoice = model.createInvoice(patientName, doctorName, amount);
		System.out.println("Invoice created with ID: " + invoice.getInvoiceId());
	}

	private void listInvoices() {
		List<InvoiceDTO> invoices = model.getInvoices();
		if (invoices.isEmpty()) {
			System.out.println("No invoices available.");
			return;
		}
		for (InvoiceDTO invoice : invoices) {
			System.out.println(invoice.getInvoiceId() + " | " + invoice.getPatientName() + " | "
					+ invoice.getDoctorName() + " | " + invoice.getTotalAmount() + " | "
					+ invoice.getPaymentStatus());
		}
	}

	private void markPaid() {
		long id = readLong("Invoice ID to mark paid: ");
		boolean updated = model.markPaid(id);
		System.out.println(updated ? "Invoice updated to Paid." : "Invoice not found.");
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
