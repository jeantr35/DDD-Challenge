package co.com.sofka.ddd.domain.inventory.entity;

import co.com.sofka.ddd.domain.inventory.value.ProviderID;
import co.com.sofka.ddd.domain.inventory.value.TotalItems;
import co.com.sofka.domain.generic.Entity;

public class Provider extends Entity<ProviderID> {

    private TotalItems totalItems;

    public Provider(ProviderID entityId, TotalItems totalItems) {
        super(entityId);
        this.totalItems = totalItems;
    }

    public Integer sendItems(Integer numberOfItems){
        this.totalItems = new TotalItems(this.totalItems.value() - numberOfItems);
        return  numberOfItems;
    }

    public TotalItems getTotalItems() {
        return totalItems;
    }
}
