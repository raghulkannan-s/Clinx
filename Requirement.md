# Clinic Management System

## Project Info
- Tech stack: Java, SQL
- Timeline: 1 month
- Team size: 1

## Phases and Time Constraints

### Phase 1
- Auth: register/login with validation
- Doctor availability setup
- Appointment booking (doctor + date/time)
- Queue status (Pending / Checked-In / Completed)
- Search doctors (name or specialization)

### Phase 2
- Billing (auto-generate after consultation)
- Prescriptions (notes/medicine)
- Patient history (visits + prescriptions)
- Payments (mark invoice as Paid)

## Core Features
- User authentication (login for patients and doctors)
- Doctor availability (consultation hours)
- Appointment booking (doctor ID + date)
- Queue status (Pending / Checked-In / Completed)
- Billing (auto-generate bill after consultation)
- Search (doctor by specialization or name)

## Patient Features
- Register / login
- View doctors and specializations
- Book appointment (doctor + date/time)
- View history (visits and prescriptions)
- Pay bill (update status to Paid)

## Doctor / Admin Features
- View appointments for the day
- Start consultation (status -> In-Progress)
- Generate prescription (notes/medicine)
- Finalize bill (set consultation fee and close appointment)

## Model Classes

### User
- id: Long
- name: String
- email: String
- password: String (hashed)
- role: Enum (Patient / Doctor / Admin)
- createdAt: Long

### Doctor
- id: Long
- userId: Long (FK - User.id)
- specialization: String (e.g., General, Cardio, Dental)
- consultationFee: Double
- experience: Integer (years)

### Appointment
- id: Long
- patientId: Long (FK - User.id)
- doctorId: Long (FK - Doctor.id)
- appointmentDate: Long
- timeSlot: String (e.g., "10:00 AM")
- status: Enum (Pending / Completed / Cancelled)

### Prescription
- id: Long
- appointmentId: Long (FK - Appointment.id)
- diagnosis: String
- medicines: String
- notes: String

### Invoice
- id: Long
- appointmentId: Long (FK - Appointment.id)
- totalAmount: Double
- paymentStatus: Enum (Paid / Unpaid)
- generatedAt: Long