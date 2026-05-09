Layer-based demo structure (non-feature-based):

src/com/raghul/clinx/
  Main.java

  services/
    AuthService.java
    DoctorService.java
    PatientService.java
    AppointmentService.java
    BillingService.java
    PrescriptionService.java

  repositories/
    AuthRepository.java
    DoctorRepository.java
    PatientRepository.java
    AppointmentRepository.java
    BillingRepository.java
    PrescriptionRepository.java

  views/
    AuthView.java
    DoctorView.java
    PatientView.java
    AppointmentView.java
    BillingView.java
    PrescriptionView.java

  data/
    dto/
      UserDTO.java
      DoctorDetailDTO.java
      AppointmentDTO.java
      InvoiceDTO.java
      LoginRequest.java

  security/
    PasswordHasher.java

Notes:
- This is a pure layer-based alternative to feature-based structure.
- Use it if you want fewer folders but it gets harder to scale as features grow.
