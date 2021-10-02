package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.commands.CreateInvoice;
import co.com.sofka.ddd.domain.invoice.events.InvoiceCreated;
import co.com.sofka.ddd.domain.invoice.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateInvoiceUseCaseTest {

    @Test
    void CreateInvoiceUseCase(){
        //arrange

        List<ProductID> productIDS = new ArrayList<ProductID>();

        var command = new CreateInvoice(
                InvoiceID.of("XX-XX-XX"), new InventoryID("XX-XX"), new PaymentMethod(0), productIDS,
                CustomerID.of("1005911531"), new Name("Jean Trujillo"), new Address("Kra 11"), new ContactNumber("3219470823"),
                new PackageMaterial(0), SellerID.of("1005923121"), new Name("Carlos Becerra")
        );

        var useCase = new CreateInvoiceUseCase();
        //act
        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert
        var eventCreation = (InvoiceCreated)events.get(0);

        Assertions.assertEquals("XX-XX-XX", eventCreation.getInvoiceID().value());
        Assertions.assertEquals(0, eventCreation.getProductIDS().size());
        Assertions.assertEquals("Jean Trujillo", eventCreation.getCustomerName().value());
        Assertions.assertEquals("XX-XX", eventCreation.getInventoryID().value());
    }

}