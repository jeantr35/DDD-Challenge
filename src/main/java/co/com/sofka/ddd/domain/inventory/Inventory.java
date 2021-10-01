package co.com.sofka.ddd.domain.inventory;

import co.com.sofka.ddd.domain.inventory.entity.Office;
import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.entity.Provider;
import co.com.sofka.ddd.domain.inventory.event.*;
import co.com.sofka.ddd.domain.inventory.value.*;
import co.com.sofka.ddd.domain.invoice.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Inventory extends AggregateEvent<InventoryID> {

    protected List<Product> products;
    protected List<Provider> providers;
    protected Office office;

    public Inventory(InventoryID inventoryID, OfficeID officeID, OfficeName officeName) {
        super(inventoryID);
        appendChange(new InventoryCreated(officeID,officeName)).apply();
    }

    private Inventory(InventoryID inventoryID){
        super(inventoryID);
        subscribe(new InventoryChange(this));
    }

    public static Inventory from(InventoryID inventoryID, List<DomainEvent> events){
        var inventory = new Inventory(inventoryID);
        events.forEach(inventory::applyEvent);
        return inventory;
    }

    public Optional<Product> getProductById(ProductID productID){
        Objects.requireNonNull(productID);
        return products.stream().filter(product -> product.identity().equals(productID)).findFirst();
    }

    public Integer getProductIndexById(ProductID productID){
        Objects.requireNonNull(productID);
        return products.indexOf(getProductById(productID).get());
    }

    public Optional<Provider> getProviderById(ProviderID providerID){
        return providers.stream().filter(provider -> provider.identity().equals(providerID)).findFirst();
    }

    public Integer getProviderIndexById(ProviderID providerID){
        Objects.requireNonNull(providerID);
        return providers.indexOf(getProviderById(providerID).get());
    }

    public void updateProductNmae(ProductID productID, String newName){
        Objects.requireNonNull(productID);
        Objects.requireNonNull(newName);
        appendChange(new ProductNameUpdated(productID, newName)).apply();
    }

    public void updateProductPrice(ProductID productID, Integer newPrice){
        Objects.requireNonNull(productID);
        Objects.requireNonNull(newPrice);
        appendChange(new ProductPriceUpdated(productID, newPrice));
    }

    public void updateProductQuanty(ProductID productID, Integer quanty, boolean addQuanty){
        Objects.requireNonNull(productID);
        Objects.requireNonNull(quanty);
        Objects.requireNonNull(addQuanty);
        appendChange(new ProductQuantyUpdated(productID, quanty, addQuanty));
    }

    public void sendProviderItems(ProviderID providerID, ProductID productID, Integer numberOfItems){ // Later
        Objects.requireNonNull(providerID);
        Objects.requireNonNull(productID);
        Objects.requireNonNull(numberOfItems);
        appendChange(new ProviderSentItems(providerID, productID, numberOfItems));
    }

    public void updateOfficeName(String newName){
        Objects.requireNonNull(newName);
        appendChange(new OfficeNameUpdated(newName));
    }

    public void addProduct(ProductID entityId, ProductPrice productPrice, ProductName productName, ProductState productState, ProductQuanty productQuanty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(productPrice);
        Objects.requireNonNull(productName);
        Objects.requireNonNull(productState);
        Objects.requireNonNull(productQuanty);
        appendChange(new ProductAdded(entityId, productPrice, productName, productState, productQuanty));
    }

    public void addProvider(ProviderID entityId, TotalItems totalItems){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(totalItems);
        appendChange(new ProviderAdded(entityId, totalItems));
    }
}
