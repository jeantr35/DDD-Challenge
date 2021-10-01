package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ContactNumberUpdated extends DomainEvent {

    private final String newNumber;

    public ContactNumberUpdated(String newNumber) {
        super("sofka.domain.invoice.contactnumberupdated");
        this.newNumber = newNumber;
    }

    public String getNewNumber() {
        return newNumber;
    }
}
