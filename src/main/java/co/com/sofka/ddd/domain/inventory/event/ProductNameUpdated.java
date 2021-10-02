package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductNameUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProductID productId;
    private final String newName;

    public ProductNameUpdated(InventoryID inventoryID,ProductID productID, String newName) {
        super("sofka.domain.inventory.productnameupdated");
        this.inventoryID = inventoryID;
        this.productId = productID;
        this.newName = newName;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProductId() {
        return productId;
    }

    public String getNewName() {
        return newName;
    }
}
