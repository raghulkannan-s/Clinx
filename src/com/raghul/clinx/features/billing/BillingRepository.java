package com.raghul.clinx.features.billing;

import com.raghul.clinx.data.dto.InvoiceDTO;
import com.raghul.clinx.data.repository.ClinXDB;
import java.util.List;

public class BillingRepository {

    public InvoiceDTO createInvoice(String patientName, String doctorName, double amount) {
        InvoiceDTO invoice = new InvoiceDTO(
                ClinXDB.nextInvoiceId(),
                patientName,
                doctorName,
                amount,
                "Pending",
                System.currentTimeMillis()
        );
        ClinXDB.addInvoice(invoice);
        return invoice;
    }

    public List<InvoiceDTO> getInvoices() {
        return ClinXDB.getInvoices();
    }

    public boolean markPaid(long invoiceId) {
        List<InvoiceDTO> invoices = ClinXDB.getInvoices();
        for (int i = 0; i < invoices.size(); i++) {
            InvoiceDTO existing = invoices.get(i);
            if (existing.getInvoiceId() == invoiceId) {
                InvoiceDTO updated = new InvoiceDTO(
                        existing.getInvoiceId(),
                        existing.getPatientName(),
                        existing.getDoctorName(),
                        existing.getTotalAmount(),
                        "Paid",
                        existing.getGeneratedAt()
                );
                invoices.set(i, updated);
                return true;
            }
        }
        return false;
    }
}
