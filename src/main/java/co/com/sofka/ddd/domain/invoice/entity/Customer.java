package co.com.sofka.ddd.domain.invoice.entity;

import co.com.sofka.ddd.domain.invoice.value.Address;
import co.com.sofka.ddd.domain.invoice.value.ContactNumber;
import co.com.sofka.ddd.domain.invoice.value.CustomerID;
import co.com.sofka.ddd.domain.invoice.value.Name;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Customer extends Entity<CustomerID> {

    private Name name;
    private Address address;
    private ContactNumber contactNumber;

    public Customer(CustomerID entityId, Name name, Address address, ContactNumber contactNumber) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public void updateContactNumber(String newNumber){
        Objects.requireNonNull(newNumber);
        this.contactNumber = new ContactNumber(newNumber);
    }

    public void updateName(String newName){
        Objects.requireNonNull(newName);
        this.name = new Name(newName);
    }

    public void updateAddresss(String newAddress){
        Objects.requireNonNull(newAddress);
        this.address = new Address(newAddress);
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
