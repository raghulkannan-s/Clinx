package com.raghul.clinx;

import com.raghul.clinx.features.appointment.AppointmentView;
import com.raghul.clinx.features.auth.AuthView;
import com.raghul.clinx.features.billing.BillingView;
import com.raghul.clinx.features.doctor.DoctorView;
import com.raghul.clinx.features.patient.PatientView;
import com.raghul.clinx.features.prescription.PrescriptionView;
import java.util.Scanner;

public class Main {

    public static final int VERSION_NO = 1;
    public static final String VERSION_NAME = "0.0.1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthView authView = new AuthView(scanner);

        if (!authView.start()) {
            return;
        }

        DoctorView doctorView = new DoctorView(scanner);
        PatientView patientView = new PatientView(scanner);
        AppointmentView appointmentView = new AppointmentView(scanner);
        BillingView billingView = new BillingView(scanner);
        PrescriptionView prescriptionView = new PrescriptionView(scanner);

        while (true) {
            System.out.println("=== ClinX Main Menu ===");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Appointments");
            System.out.println("4. Billing");
            System.out.println("5. Prescriptions");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    doctorView.start();
                    break;
                case "2":
                    patientView.start();
                    break;
                case "3":
                    appointmentView.start();
                    break;
                case "4":
                    billingView.start();
                    break;
                case "5":
                    prescriptionView.start();
                    break;
                case "0":
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }

    }
}