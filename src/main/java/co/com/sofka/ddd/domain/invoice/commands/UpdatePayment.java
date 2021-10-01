package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdatePayment extends Command {

    private final Integer newPayment;

    public UpdatePayment(Integer newPayment) {
        this.newPayment = newPayment;
    }

    public Integer getNewPayment() {
        return newPayment;
    }

}
