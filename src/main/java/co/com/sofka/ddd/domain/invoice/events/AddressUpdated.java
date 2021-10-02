package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.DomainEvent;

public class AddressUpdated extends DomainEvent {

    private final String newAddress;
    private final InvoiceID invoiceID;

    public AddressUpdated(InvoiceID invoiceID, String newAddress) {
        super("sofka.domain.invoice.addressupdated");
        this.invoiceID = invoiceID;
        this.newAddress = newAddress;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public String getNewAddress() {
        return newAddress;
    }
}
