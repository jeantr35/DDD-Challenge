package co.com.sofka.ddd.domain.invoice.entity;

import co.com.sofka.ddd.domain.invoice.value.Name;
import co.com.sofka.ddd.domain.invoice.value.SellerID;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Seller extends Entity<SellerID> {

    private Name name;

    public Seller(SellerID entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public void updateName(String newName){
        Objects.requireNonNull(newName);
        this.name = new Name(newName);
    }

    public Name getName() {
        return name;
    }
}
