package co.com.sofka.ddd.domain;

import co.com.sofka.ddd.domain.entity.Office;
import co.com.sofka.ddd.domain.entity.Product;
import co.com.sofka.ddd.domain.entity.Provider;
import co.com.sofka.ddd.domain.event.InventoryCreated;
import co.com.sofka.ddd.domain.value.InventoryID;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Inventory extends AggregateEvent<InventoryID> {


    private List<Product> products;
    private List<Provider> providers;
    private Office office;


    public Inventory(InventoryID inventoryID, List<Product> products, List<Provider> providers, Office office) {
        super(inventoryID);
        appendChange(new InventoryCreated(products, providers, office)).apply();
    }
}
