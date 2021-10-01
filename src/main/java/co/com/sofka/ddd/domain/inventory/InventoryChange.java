package co.com.sofka.ddd.domain.inventory;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.entity.Provider;
import co.com.sofka.ddd.domain.inventory.event.*;
import co.com.sofka.domain.generic.EventChange;

public class InventoryChange extends EventChange {

    public InventoryChange(Inventory inventory){

        apply((InventoryCreated event) -> {
            inventory.products = event.getProducts();
            inventory.providers = event.getProviders();
            inventory.office = event.getOffice();
        });

        apply((ProductAdded event) -> {
            var product = new Product(event.getProductID(), event.getProductPrice(), event.getProductName(), event.getProductState(), event.getProductQuanty());
            inventory.products.add(product);
        });

        apply((ProductNameUpdated event) -> {
            var product = inventory.getProductById(event.getProductId()).get();
            var index = inventory.getProductIndexById(event.getProductId());
            product.updateProductName(event.getNewName());
            inventory.products.set(index, product);
        });

        apply((ProductPriceUpdated event) -> {
            var product = inventory.getProductById(event.getProductID()).get();
            var index = inventory.getProductIndexById(event.getProductID());
            product.updateProductPrice(event.getNewPrice());
            inventory.products.set(index, product);
        });

        apply((ProductQuantyUpdated event) -> {
            var product = inventory.getProductById(event.getProductID()).get();
            var index = inventory.getProductIndexById(event.getProductID());
            product.updateProductQuanty(event.getQuanty(),event.isAddQuanty());
            inventory.products.set(index, product);
        });

        apply((ProviderAdded event) -> {
            var provider = new Provider(event.getProviderID(), event.getTotalItems());
            inventory.providers.add(provider);
        });

        apply((OfficeNameUpdated event) -> {
            inventory.office.updateName(event.getNewName());
        });

        apply((ProviderSentItems event) ->{
            var provider = inventory.getProviderById(event.getProviderID()).get();
            var product = inventory.getProductById(event.getProductID()).get();
            var providerIndex = inventory.getProviderIndexById(event.getProviderID());
            var productIndex = inventory.getProductIndexById(event.getProductID());
            product.updateProductQuanty(provider.sendItems(event.getNumberOfItems()), true);
            inventory.products.set(productIndex, product);
            inventory.providers.set(providerIndex, provider);
        });

    }

}
