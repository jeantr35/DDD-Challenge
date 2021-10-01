package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.domain.generic.Command;

public class UpdateProductName extends Command {

    private final Product product;
    private final String newName;

    public UpdateProductName(Product product, String newName) {
        this.product = product;
        this.newName = newName;
    }

    public Product getProduct() {
        return product;
    }

    public String getNewName() {
        return newName;
    }
}
