package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class SellerNameUpdated extends DomainEvent {

    private final String newName;

    public SellerNameUpdated(String newName) {
        super("sofka.domain.invoice.sellernameupdated");
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
}
