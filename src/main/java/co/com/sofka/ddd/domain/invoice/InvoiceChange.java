package co.com.sofka.ddd.domain.invoice;

import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.invoice.entity.Customer;
import co.com.sofka.ddd.domain.invoice.entity.Package;
import co.com.sofka.ddd.domain.invoice.entity.Seller;
import co.com.sofka.ddd.domain.invoice.events.*;
import co.com.sofka.ddd.domain.invoice.value.PackageID;
import co.com.sofka.ddd.domain.invoice.value.PaymentMethod;
import co.com.sofka.domain.generic.EventChange;

public class InvoiceChange extends EventChange {

    public InvoiceChange(Invoice invoice){

        apply((InvoiceCreated event) ->{
            invoice.paymentMethod = event.getPaymentMethod();
            invoice.productIDS = event.getProductIDS();
            invoice.customer = new Customer(event.getCustomerID(), event.getCustomerName(), event.getCustomerAddress(), event.getCustomerNumber());
            invoice.seller = new Seller(event.getSellerID(), event.getSellerName());
            invoice.aPackage = new Package(PackageID.of(event.getCustomerID().value()), event.getPackageMaterial());
        });

        apply((AddressUpdated event) ->{
            invoice.customer.updateAddresss(event.getNewAddress());
        });

        apply((ContactNumberUpdated event) ->{
            invoice.customer.updateContactNumber(event.getNewNumber());
        });

        apply((CustomerNameUpdated event) ->{
            invoice.customer.updateName(event.getNewName());
        });

        apply((PackageMaterialUpdated event) ->{
            invoice.aPackage.updatePackageMatherial(event.getNewMaterial());
        });

        apply((PaymentUpdated event) ->{
            invoice.paymentMethod = new PaymentMethod(event.getNewPayment());
        });

        apply((SellerNameUpdated event) ->{
            invoice.seller.updateName(event.getNewName());
        });

        apply((TotalPriceCalculated event) ->{
            // Generar el inventario de nuevo a partir de la ID
        });

    }

}
