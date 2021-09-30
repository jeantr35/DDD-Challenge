package co.com.sofka.DDD.domain;

import co.com.sofka.DDD.domain.entity.Office;
import co.com.sofka.DDD.domain.entity.Product;
import co.com.sofka.DDD.domain.entity.Provider;
import co.com.sofka.DDD.domain.event.InventoryCreated;
import co.com.sofka.DDD.domain.value.InventoryID;
import co.com.sofka.DDD.domain.value.InvoiceID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.domain.generic.Identity;

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
