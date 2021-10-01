package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.ddd.domain.inventory.value.TotalItems;
import co.com.sofka.domain.generic.DomainEvent;

public class OfficeNameUpdated extends DomainEvent {

    private final String newName;

    public OfficeNameUpdated(String newName) {
        super("sofka.domain.inventory.officenameupdated");
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
}
