package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

public class UpdateProductName extends Command {

    private final InventoryID inventoryID;
    private final Product product;
    private final String newName;

    public UpdateProductName(InventoryID inventoryID, Product product, String newName) {
        this.inventoryID = inventoryID;
        this.product = product;
        this.newName = newName;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public Product getProduct() {
        return product;
    }

    public String getNewName() {
        return newName;
    }
}
