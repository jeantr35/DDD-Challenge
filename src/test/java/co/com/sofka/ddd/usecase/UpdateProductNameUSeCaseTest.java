package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.inventory.command.AddProduct;
import co.com.sofka.ddd.domain.inventory.command.UpdateProductName;
import co.com.sofka.ddd.domain.inventory.entity.Product;
import co.com.sofka.ddd.domain.inventory.event.InventoryCreated;
import co.com.sofka.ddd.domain.inventory.event.ProductAdded;
import co.com.sofka.ddd.domain.inventory.event.ProductNameUpdated;
import co.com.sofka.ddd.domain.inventory.value.*;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateProductNameUSeCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateProduct(){
        //arrange
        var aggregateID = "xxx-xxx";
        var product = new Product(new ProductID("kumara"), new ProductPrice(180000),
                new ProductName("KumaraK552"), new ProductState(0),new ProductQuanty(2));

        var command = new UpdateProductName(InventoryID.of(aggregateID), product,"PAPAPAPA");

        var useCase = new UpdateProductNameUSeCase();

        Mockito.when(repository.getEventsBy(aggregateID)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert

        var eventCreation = (ProductNameUpdated)events.get(0);

        Assertions.assertEquals("PAPAPAPA", eventCreation.getNewName());
        Mockito.verify(repository).getEventsBy(aggregateID);
    }

    private List<DomainEvent> eventStored() {

        return List.of(
                new InventoryCreated(new InventoryID("xxx-xxx"),new OfficeID(), new OfficeName("Ibague")),
                new ProductAdded(new InventoryID("xxx-xxx"), new ProductID("kumara"), new ProductPrice(180000),
                        new ProductName("KumaraK552"), new ProductState(0),new ProductQuanty(2))
        );
    }

}