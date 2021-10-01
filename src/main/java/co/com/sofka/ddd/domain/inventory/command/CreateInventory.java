package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.ddd.domain.inventory.entity.Office;
import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.entity.Provider;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class CreateInventory extends Command {

    private final InventoryID inventoryID;
    private final List<Product> products;
    private final List<Provider> providers;
    private final Office office;

    public CreateInventory(InventoryID inventoryID, Office office) {
        this.inventoryID = inventoryID;
        this.products = new ArrayList<Product>();
        this.providers = new ArrayList<Provider>();
        this.office = office;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
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
