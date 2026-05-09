package com.raghul.clinx.data.dto;

public class InvoiceDTO {
    private Long invoiceId;
    private String patientName;
    private String doctorName;
    private Double totalAmount;
    private String paymentStatus;
    private Long generatedAt;

    public InvoiceDTO(Long invoiceId, String patientName, String doctorName, Double totalAmount, String paymentStatus, Long generatedAt) {
        this.invoiceId = invoiceId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.generatedAt = generatedAt;
    }

    public Long getInvoiceId() { return invoiceId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public Double getTotalAmount() { return totalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public Long getGeneratedAt() { return generatedAt; }
}