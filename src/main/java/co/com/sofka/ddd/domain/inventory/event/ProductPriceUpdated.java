package co.com.sofka.ddd.domain.inventory.event;


import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductPriceUpdated extends DomainEvent {

    private final ProductID productID;
    private final Integer newPrice;

    public ProductPriceUpdated(ProductID productID, Integer newPrice) {
        super("sofka.domain.inventory.productpriceupdated");
        this.productID = productID;
        this.newPrice = newPrice;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

}
