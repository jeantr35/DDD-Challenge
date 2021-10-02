package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.DomainEvent;

public class PaymentUpdated extends DomainEvent {

    private final InvoiceID invoiceID;
    private final Integer newPayment;

    public PaymentUpdated(InvoiceID invoiceID, Integer newPayment) {
        super("sofka.domain.invoice.paymentupdated");
        this.invoiceID = invoiceID;
        this.newPayment = newPayment;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public Integer getNewPayment() {
        return newPayment;
    }
}
