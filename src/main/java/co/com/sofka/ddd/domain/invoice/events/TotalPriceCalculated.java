package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class TotalPriceCalculated extends DomainEvent {

    private final List<Product> products;

    public TotalPriceCalculated(List<Product> products) {
        super("sofka.domain.invoice.totalpricecalculated");
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
