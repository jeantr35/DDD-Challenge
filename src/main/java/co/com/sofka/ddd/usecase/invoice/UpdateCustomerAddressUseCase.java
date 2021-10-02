package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.commands.UpdateAddress;

public class UpdateCustomerAddressUseCase extends UseCase<RequestCommand<UpdateAddress>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAddress> updateAddressRequestCommand) {
        var command = updateAddressRequestCommand.getCommand();
        Invoice invoice;
        invoice = Invoice.from(command.getInvoiceID(),retrieveEvents(command.getInvoiceID().value()));

        invoice.updateAddres(command.getNewAddress());
        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));

    }
}
