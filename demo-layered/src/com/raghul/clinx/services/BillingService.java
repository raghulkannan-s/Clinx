package com.raghul.clinx.services;

import com.raghul.clinx.data.dto.InvoiceDTO;
import com.raghul.clinx.repositories.BillingRepository;
import java.util.List;

public class BillingService {

    private final BillingRepository repository;

    public BillingService() {
        this.repository = new BillingRepository();
    }

    public InvoiceDTO createInvoice(String patientName, String doctorName, double amount) {
        return repository.createInvoice(patientName, doctorName, amount);
    }

    public List<InvoiceDTO> getInvoices() {
        return repository.getInvoices();
    }

    public boolean markPaid(long invoiceId) {
        return repository.markPaid(invoiceId);
    }
}
