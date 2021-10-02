package co.com.sofka.ddd.usecase.invoice;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.inventory.command.UpdateOfficeName;
import co.com.sofka.ddd.domain.inventory.event.InventoryCreated;
import co.com.sofka.ddd.domain.inventory.event.OfficeNameUpdated;
import co.com.sofka.ddd.domain.inventory.value.OfficeID;
import co.com.sofka.ddd.domain.inventory.value.OfficeName;
import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.ddd.domain.invoice.commands.UpdateAddress;
import co.com.sofka.ddd.domain.invoice.events.AddressUpdated;
import co.com.sofka.ddd.domain.invoice.events.InvoiceCreated;
import co.com.sofka.ddd.domain.invoice.value.*;
import co.com.sofka.ddd.usecase.inventory.UpdateOfficeNameUseCase;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerAddressUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateCustomerAddress(){
        //arrange
        var aggregateID = "xxx-xxx";
        var command = new UpdateAddress(InvoiceID.of(aggregateID), "Panaland");

        var useCase = new UpdateCustomerAddressUseCase();

        Mockito.when(repository.getEventsBy(aggregateID)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert

        var eventCreation = (AddressUpdated)events.get(0);

        Assertions.assertEquals("Panaland", eventCreation.getNewAddress());
        Mockito.verify(repository).getEventsBy(aggregateID);
    }


    private List<DomainEvent> eventStored() {

        List<ProductID> productIDS = new ArrayList<ProductID>();
        return List.of(
                new InvoiceCreated(InvoiceID.of("xxx-xxx"), new InventoryID("XX-XX"), new PaymentMethod(0), productIDS,
                        CustomerID.of("1005911531"), new Name("Jean Trujillo"), new Address("Kra 11"), new ContactNumber("3219470823"),
                        new PackageMaterial(0), SellerID.of("1005923121"), new Name("Carlos Becerra"))
        );

    }

}