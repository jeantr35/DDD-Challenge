package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.Command;

public class UpdateContactNumber extends Command {

    private final InvoiceID invoiceID;
    private final String newNumber;

    public UpdateContactNumber(InvoiceID invoiceID, String newNumber) {
        this.invoiceID = invoiceID;
        this.newNumber = newNumber;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public String getNewNumber() {
        return newNumber;
    }

}
