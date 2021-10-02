package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.commands.UpdateContactNumber;

public class UpdateContactNumberUseCase extends UseCase<RequestCommand<UpdateContactNumber>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateContactNumber> updateContactNumberRequestCommand) {
        var command = updateContactNumberRequestCommand.getCommand();
        Invoice invoice;
        invoice = Invoice.from(command.getInvoiceID(),retrieveEvents(command.getInvoiceID().value()));

        invoice.updateContactNumber(command.getNewNumber());
        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
