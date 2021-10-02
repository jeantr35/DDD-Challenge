package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.commands.CreateInvoice;

public class CreateInvoiceUseCase extends UseCase<RequestCommand<CreateInvoice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInvoice> createInvoiceRequestCommand) {

        var command = createInvoiceRequestCommand.getCommand();
        Invoice invoice;

        invoice = new Invoice(command.getInvoiceID(), command.getInventoryID(), command.getPaymentMethod(), command.getProductIDS(),
                command.getCustomerID(), command.getCustomerName(), command.getCustomerAddress(), command.getCustomerNumber(), command.getPackageMaterial(),
                command.getSellerID(), command.getSellerName()
        );

        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));

    }
}
