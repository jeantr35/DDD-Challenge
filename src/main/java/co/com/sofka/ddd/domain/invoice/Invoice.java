package co.com.sofka.ddd.domain.invoice;

import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.entity.Customer;
import co.com.sofka.ddd.domain.invoice.entity.Package;
import co.com.sofka.ddd.domain.invoice.entity.Seller;
import co.com.sofka.ddd.domain.invoice.events.*;
import co.com.sofka.ddd.domain.invoice.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Invoice extends AggregateEvent<InvoiceID> {

    protected TotalPrice totalPrice;
    protected PaymentMethod paymentMethod;
    protected List<ProductID> productIDS;
    protected List<Product> products;
    protected Customer customer;
    protected Seller seller;
    protected Package aPackage;


    public Invoice(InvoiceID entityId, InventoryID inventoryID, PaymentMethod paymentMethod, List<ProductID> productIDS, CustomerID customerID, Name customerName, Address customerAddress,
                   ContactNumber customerNumber, PackageMaterial packageMaterial, SellerID sellerID, Name sellerName) {
        super(entityId);
        appendChange(new InvoiceCreated(entityId, inventoryID, paymentMethod, productIDS, customerID, customerName, customerAddress, customerNumber, packageMaterial, sellerID, sellerName)).apply();
    }

    private Invoice(InvoiceID invoiceID) {
        super(invoiceID);
        subscribe(new InvoiceChange(this));
    }

    public static Invoice from(InvoiceID invoiceID, List<DomainEvent> events) {
        var invoice = new Invoice(invoiceID);
        events.forEach(invoice::applyEvent);
        return invoice;
    }

    public void calculateTotalPrice(){
        appendChange(new TotalPriceCalculated(this.products)).apply();
    }

    public void updatePaymentMethod(Integer paymentMethod){
        Objects.requireNonNull(paymentMethod);
        appendChange(new PaymentUpdated(this.identity(), paymentMethod)).apply();
    }

    public void generateProductLst(){
        appendChange(new ProductListGenerated(this.productIDS)).apply(); //pasar ID inventario
    }

    public void updateContactNumber(String nemNumber){
        appendChange(new ContactNumberUpdated(this.identity(), nemNumber)).apply();
    }

    public void updatePackageMatherial(Integer packageMatherial){
        appendChange(new PackageMaterialUpdated(packageMatherial)).apply();
    }

    public void updateAddres(String newAddress){
        appendChange(new AddressUpdated(this.identity(), newAddress)).apply();
    }

    public void updateCustomerName(String newName){
        appendChange(new CustomerNameUpdated(newName)).apply();
    }

    public void updateSellerName(String newName){
        appendChange(new SellerNameUpdated(newName)).apply();
    }

}
