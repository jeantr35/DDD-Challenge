package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.invoice.value.InvoiceID;
import co.com.sofka.domain.generic.Command;

public class UpdatePayment extends Command {

    private final InvoiceID invoiceID;
    private final Integer newPayment;

    public UpdatePayment(InvoiceID invoiceID, Integer newPayment) {
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
