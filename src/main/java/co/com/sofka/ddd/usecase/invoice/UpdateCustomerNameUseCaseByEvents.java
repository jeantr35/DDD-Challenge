package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.events.CustomerNameUpdated;
import co.com.sofka.ddd.domain.invoice.events.PaymentUpdated;

public class UpdateCustomerNameUseCaseByEvents extends UseCase<TriggeredEvent<CustomerNameUpdated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CustomerNameUpdated> customerNameUpdatedTriggeredEvent) {

        var event = customerNameUpdatedTriggeredEvent.getDomainEvent();
        var invoice = Invoice.from(event.getInvoiceID(),retrieveEvents(event.getInvoiceID().value()));

        invoice.updateCustomerName(event.getNewName());
        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));

    }
}
