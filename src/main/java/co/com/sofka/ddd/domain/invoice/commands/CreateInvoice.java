package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.Invoice;
import co.com.sofka.ddd.domain.invoice.value.*;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class CreateInvoice extends Command {

    private final InvoiceID invoiceID;
    private final PaymentMethod paymentMethod;
    private final List<ProductID> productIDS;
    private final CustomerID customerID;
    private final Name customerName;
    private final Address customerAddress;
    private final ContactNumber customerNumber;
    private final PackageMaterial packageMaterial;
    private final SellerID sellerID;
    private final Name sellerName;
    private final InventoryID inventoryID;

    public CreateInvoice(InvoiceID invoiceID, InventoryID inventoryID, PaymentMethod paymentMethod, List<ProductID> productIDS, CustomerID customerID, Name customerName, Address customerAddress, ContactNumber customerNumber, PackageMaterial packageMaterial, SellerID sellerID, Name sellerName) {
        this.invoiceID = invoiceID;
        this.inventoryID = inventoryID;
        this.paymentMethod = paymentMethod;
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.productIDS = productIDS;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.packageMaterial = packageMaterial;
        this.sellerID = sellerID;
        this.sellerName = sellerName;
    }

    public InventoryID getInventoryID() {
        return inventoryID;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<ProductID> getProductIDS() {
        return productIDS;
    }

    public CustomerID getCustomerID() {
        return customerID;
    }

    public Name getCustomerName() {
        return customerName;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public ContactNumber getCustomerNumber() {
        return customerNumber;
    }

    public PackageMaterial getPackageMaterial() {
        return packageMaterial;
    }

    public SellerID getSellerID() {
        return sellerID;
    }

    public Name getSellerName() {
        return sellerName;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }
}


