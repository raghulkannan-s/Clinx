package com.raghul.clinx.features.billing;

import com.raghul.clinx.data.dto.InvoiceDTO;
import java.util.List;
import java.util.Scanner;

public class BillingView {

	private final BillingService service;
	private final Scanner scanner;

	public BillingView(Scanner scanner) {
		this.service = new BillingService();
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
		String patientName = readRequired("Patient name: ");
		String doctorName = readRequired("Doctor name: ");
		double amount = readPositiveDouble("Total amount: ");

		InvoiceDTO invoice = service.createInvoice(patientName, doctorName, amount);
		System.out.println("Invoice created with ID: " + invoice.getInvoiceId());
	}

	private void listInvoices() {
		List<InvoiceDTO> invoices = service.getInvoices();
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
		boolean updated = service.markPaid(id);
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

	private double readPositiveDouble(String prompt) {
		while (true) {
			double value = readDouble(prompt);
			if (value > 0) {
				return value;
			}
			System.out.println("Amount must be greater than zero.");
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
