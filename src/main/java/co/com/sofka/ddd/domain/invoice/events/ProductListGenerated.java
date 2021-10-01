package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class ProductListGenerated extends DomainEvent {

    private final List<ProductID> productIDS;

    public ProductListGenerated(List<ProductID> productIDS) {
        super("sofka.domain.invoice.productlistgenerated");
        this.productIDS = productIDS;
    }

    public List<ProductID> getProductIDS() {
        return productIDS;
    }
}
