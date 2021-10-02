package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

public class UpdateOfficeName extends Command {

    private final InventoryID inventoryID;
    private final String newName;

    public UpdateOfficeName(InventoryID inventoryID, String newName) {
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
