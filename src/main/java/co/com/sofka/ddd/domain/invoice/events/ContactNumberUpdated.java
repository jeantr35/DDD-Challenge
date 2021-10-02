package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactNumberUpdated extends DomainEvent {

    private final InvoiceID invoiceID;
    private final String newNumber;

    public ContactNumberUpdated(InvoiceID invoiceID,String newNumber) {
        super("sofka.domain.invoice.contactnumberupdated");
        this.newNumber = newNumber;
        this.invoiceID = invoiceID;
    }

    public String getNewNumber() {
        return newNumber;
    }
}
