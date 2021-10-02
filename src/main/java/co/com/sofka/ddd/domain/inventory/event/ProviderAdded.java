package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.ddd.domain.inventory.value.TotalItems;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProviderAdded extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProviderID providerID;
    private final TotalItems totalItems;

    public ProviderAdded(InventoryID inventoryID, ProviderID providerID, TotalItems totalItems) {
        super("sofka.domain.inventory.provideradded");
        this.inventoryID = inventoryID;
        this.providerID = providerID;
        this.totalItems = totalItems;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProviderID getProviderID() {
        return providerID;
    }

    public TotalItems getTotalItems() {
        return totalItems;
    }
}
