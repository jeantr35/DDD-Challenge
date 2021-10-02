package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

public class UpdateProductQuanty extends Command {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final Integer quanty;
    private final boolean addQuanty;

    public UpdateProductQuanty(InventoryID inventoryID, ProductID productID, Integer quanty, boolean addQuanty) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.quanty = quanty;
        this.addQuanty = addQuanty;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProduct() {
        return productID;
    }

    public Integer getQuanty() {
        return quanty;
    }

    public boolean isAddQuanty() {
        return addQuanty;
    }

}
