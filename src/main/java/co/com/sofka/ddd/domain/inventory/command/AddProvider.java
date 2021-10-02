package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.ddd.domain.inventory.value.TotalItems;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

public class AddProvider extends Command {

    private final InventoryID inventoryID;
    private final ProviderID providerID;
    private final TotalItems totalItems;

    public AddProvider(InventoryID inventoryID, ProviderID providerID, TotalItems totalItems) {
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
