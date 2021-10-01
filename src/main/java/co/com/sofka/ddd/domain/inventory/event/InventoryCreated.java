package co.com.sofka.ddd.domain.inventory.event;

import co.com.sofka.ddd.domain.inventory.entity.Office;
import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.entity.Provider;
import co.com.sofka.ddd.domain.inventory.value.OfficeID;
import co.com.sofka.ddd.domain.inventory.value.OfficeName;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;


public class InventoryCreated extends DomainEvent {

    private final List<Product> products;
    private final List<Provider> providers;
    private final Office office;

    public InventoryCreated(OfficeID officeID, OfficeName officeName) {
        super("sofka.domain.inventory.inventorycreated");
        this.products = new ArrayList<Product>();
        this.providers = new ArrayList<Provider>();
        this.office = new Office(officeID, officeName);
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
