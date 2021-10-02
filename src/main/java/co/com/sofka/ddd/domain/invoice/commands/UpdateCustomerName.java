package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.Command;

public class UpdateCustomerName extends Command {

    private final InvoiceID invoiceID;
    private final String newName;

    public UpdateCustomerName(InvoiceID invoiceID, String newName) {
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
