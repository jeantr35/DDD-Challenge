package co.com.sofka.ddd.domain.inventory.event;


import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductPriceUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final Integer newPrice;

    public ProductPriceUpdated(InventoryID inventoryID, ProductID productID, Integer newPrice) {
        super("sofka.domain.inventory.productpriceupdated");
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.newPrice = newPrice;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

}
