package co.com.sofka.ddd.domain.inventory.entity;

import co.com.sofka.ddd.domain.inventory.value.*;
import co.com.sofka.domain.generic.Entity;

public class Product extends Entity<ProductID> {

    private ProductPrice productPrice;
    private ProductName productName;
    private ProductState productState;
    private ProductQuanty productQuanty;

    public Product(ProductID entityId, ProductPrice productPrice, ProductName productName, ProductState productState, ProductQuanty productQuanty) {
        super(entityId);
        this.productPrice = productPrice;
        this.productName = productName;
        this.productState = productState;
        this.productQuanty = productQuanty;
    }

    public void updateProductPrice(Integer newPrice){
        productPrice = new ProductPrice(newPrice);
    }

    public void updateProductQuanty(Integer quanty, Boolean addQuanty){
        if(addQuanty) productQuanty = new ProductQuanty(quanty + productQuanty.value());
        else productQuanty = new ProductQuanty(quanty - productQuanty.value());
    }

    public void updateProductName(String newName){
        productName = new ProductName(newName);
    }

}
