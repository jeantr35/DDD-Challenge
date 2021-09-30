package co.com.sofka.DDD.domain.event;

import co.com.sofka.DDD.domain.entity.Office;
import co.com.sofka.DDD.domain.entity.Product;
import co.com.sofka.DDD.domain.entity.Provider;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;


public class InventoryCreated extends DomainEvent {

    private final List<Product> products;
    private final List<Provider> providers;
    private final Office office;

    public InventoryCreated(List<Product> products, List<Provider> providers, Office office) {
        super("sofka.domain.inventory.inventorycreated");
        this.products = products;
        this.providers = providers;
        this.office = office;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public Office getOffice() {
        return office;
    }
}
