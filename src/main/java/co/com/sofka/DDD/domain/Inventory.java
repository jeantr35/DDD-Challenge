package co.com.sofka.DDD.domain;

import co.com.sofka.DDD.domain.entity.Office;
import co.com.sofka.DDD.domain.entity.Product;
import co.com.sofka.DDD.domain.entity.Provider;
import co.com.sofka.DDD.domain.value.InventoryID;
import co.com.sofka.DDD.domain.value.InvoiceID;
import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.domain.generic.Identity;

import java.util.List;

public class Inventory extends AggregateRoot {

    private final InventoryID inventoryID;
    private InvoiceID invoiceID;
    private List<Product> products;
    private List<Provider> providers;
    private Office office;


    public Inventory(InventoryID inventoryID) {
        super(inventoryID);
    }
}
