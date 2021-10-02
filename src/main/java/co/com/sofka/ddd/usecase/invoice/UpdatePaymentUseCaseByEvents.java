package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.events.PaymentUpdated;

public class UpdatePaymentUseCaseByEvents extends UseCase<TriggeredEvent<PaymentUpdated>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<PaymentUpdated> paymentUpdatedTriggeredEvent) {

        var event = paymentUpdatedTriggeredEvent.getDomainEvent();
        var invoice = Invoice.from(event.getInvoiceID(),retrieveEvents(event.getInvoiceID().value()));

        invoice.updatePaymentMethod(event.getNewPayment());
        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));

    }
}
