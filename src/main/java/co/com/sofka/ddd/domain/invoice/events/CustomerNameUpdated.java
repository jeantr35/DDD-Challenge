package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class CustomerNameUpdated extends DomainEvent {

    private final String newName;

    public CustomerNameUpdated(String newName) {
        super("sofka.domain.invoice.customernameupdated");
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
}
