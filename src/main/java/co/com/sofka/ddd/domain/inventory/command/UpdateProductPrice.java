package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.domain.generic.Command;

public class UpdateProductPrice extends Command {

    private final ProductID productID;
    private final Integer newPrice;

    public UpdateProductPrice(ProductID productID, Integer newPrice) {
        this.productID = productID;
        this.newPrice = newPrice;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public ProductID getProductID() {
        return productID;
    }
}
