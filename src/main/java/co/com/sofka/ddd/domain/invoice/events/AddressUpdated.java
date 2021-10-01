package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AddressUpdated extends DomainEvent {

    private final String newAddress;

    public AddressUpdated(String newAddress) {
        super("sofka.domain.invoice.addressupdated");
        this.newAddress = newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }
}
