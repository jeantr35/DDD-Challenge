package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductNameUpdated extends DomainEvent {

    private final ProductID productId;
    private final String newName;

    public ProductNameUpdated(ProductID productID, String newName) {
        super("sofka.domain.inventory.productnameupdated");
        this.productId = productID;
        this.newName = newName;
    }

    public ProductID getProductId() {
        return productId;
    }

    public String getNewName() {
        return newName;
    }
}
