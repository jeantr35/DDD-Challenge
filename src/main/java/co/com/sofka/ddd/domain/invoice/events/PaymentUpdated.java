package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PaymentUpdated extends DomainEvent {

    private final Integer newPayment;

    public PaymentUpdated(Integer newPayment) {
        super("sofka.domain.invoice.paymentupdated");
        this.newPayment = newPayment;
    }

    public Integer getNewPayment() {
        return newPayment;
    }
}
