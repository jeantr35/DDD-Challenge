package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProviderSentItems extends DomainEvent {

    private final ProviderID providerID;
    private final ProductID productID;
    private final Integer numberOfItems;

    public ProviderSentItems(ProviderID providerID, ProductID productID, Integer numberOfItems) {
        super("sofka.domain.inventory.providersentitems");
        this.providerID = providerID;
        this.productID = productID;
        this.numberOfItems = numberOfItems;
    }

    public ProviderID getProviderID() {
        return providerID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }
}
