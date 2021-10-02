package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.DomainEvent;

public class CustomerNameUpdated extends DomainEvent {

    private final InvoiceID invoiceID;
    private final String newName;

    public CustomerNameUpdated(InvoiceID invoiceID, String newName) {
        super("sofka.domain.invoice.customernameupdated");
        this.invoiceID = invoiceID;
        this.newName = newName;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public String getNewName() {
        return newName;
    }
}
