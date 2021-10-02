package co.com.sofka.ddd.domain.inventory.event;


import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductQuantyUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final Integer quanty;
    private final boolean addQuanty;

    public ProductQuantyUpdated(InventoryID inventoryID, ProductID productID, Integer quanty, boolean addQuanty) {
        super("sofka.domain.inventory.productquantyupdated");
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.quanty = quanty;
        this.addQuanty = addQuanty;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Integer getQuanty() {
        return quanty;
    }

    public boolean isAddQuanty() {
        return addQuanty;
    }
}
