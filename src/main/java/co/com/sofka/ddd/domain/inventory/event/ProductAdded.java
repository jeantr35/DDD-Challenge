package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.value.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductAdded extends DomainEvent {

    private final ProductID productID;
    private final ProductPrice productPrice;
    private final ProductName productName;
    private final ProductState productState;
    private final ProductQuanty productQuanty;

    public ProductAdded(ProductID productID, ProductPrice productPrice, ProductName productName, ProductState productState, ProductQuanty productQuanty) {
        super("sofka.domain.inventory.productadded");
        this.productID = productID;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productState = productState;
        this.productQuanty = productQuanty;
    }

    public ProductID getProductID() {
        return productID;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductState getProductState() {
        return productState;
    }

    public ProductQuanty getProductQuanty() {
        return productQuanty;
    }
}
