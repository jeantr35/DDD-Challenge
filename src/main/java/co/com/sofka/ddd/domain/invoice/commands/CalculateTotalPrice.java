package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class CalculateTotalPrice extends Command {

    private final List<Product> products;

    public CalculateTotalPrice(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}
