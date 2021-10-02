package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.ddd.domain.inventory.value.TotalItems;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;

public class OfficeNameUpdated extends DomainEvent {

    private final String newName;
    private final InventoryID inventoryID;

    public OfficeNameUpdated(InventoryID inventoryID, String newName) {
        super("sofka.domain.inventory.officenameupdated");
        this.inventoryID = inventoryID;
        this.newName = newName;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public String getNewName() {
        return newName;
    }
}
