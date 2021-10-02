package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

public class UpdateProductPrice extends Command {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final Integer newPrice;

    public UpdateProductPrice(InventoryID inventoryID, ProductID productID, Integer newPrice) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.newPrice = newPrice;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public ProductID getProductID() {
        return productID;
    }
}
