Clinic Management System
TechStack: Java, SQL
Time: 1 Month
Team Members: 1

Features:
● User Authentication: Login for Patients and Doctors.
● Doctor Availability: Doctors set their consultation hours.
● Appointment Booking: Patients book a slot based on doctor ID and date.
● Queue Status: View current appointment status (Pending / Checked-In / Completed).
● Billing: Automatic generation of a bill after consultation.
● Search: Find doctors by specialization or name.
Patient:
● Register / Login
● View Doctors: List available doctors and their specializations.
● Book Appointment: Choose a doctor and a date/time.
● View My History: Check previous visits and prescriptions.
● Pay Bill: Simple status update to "Paid."
Doctor / Admin:
● View Appointments: See the list of patients for the day.
● Start Consultation: Update appointment status to "In-Progress."
● Generate Prescription: Add notes/medicine for the patient.
● Finalize Bill: Close the appointment and set the consultation fee.

Model Classes:

User: ● id : Long ● name : String ● email : String ● password : String (Hashed) ● role : Enum (Patient / Doctor / Admin) ● createdAt : Long
Doctor: ● id : Long ● userId : Long (FK - User.id) ● specialization : String (e.g., General, Cardio, Dental) ● consultationFee : Double ● experience : Integer (Years)
Appointment: ● id : Long ● patientId : Long (FK - User.id) ● doctorId : Long (FK - Doctor.id) ● appointmentDate : Long ● timeSlot : String (e.g., "10:00 AM") ● status : Enum (Pending / Completed / Cancelled)
Prescription: ● id : Long ● appointmentId : Long (FK - Appointment.id) ● diagnosis : String ● medicines : String ● notes : String
Invoice: ● id : Long ● appointmentId : Long (FK - Appointment.id) ● totalAmount : Double ● paymentStatus : Enum (Paid / Unpaid) ● generatedAt : Long