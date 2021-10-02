package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.Command;

public class UpdateAddress extends Command {
    private final String newAddress;
    public final InvoiceID invoiceID;

    public UpdateAddress(InvoiceID invoiceID, String newAddress) {
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
