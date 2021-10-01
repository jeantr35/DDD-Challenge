package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.inventory.command.AddProduct;
import co.com.sofka.ddd.domain.inventory.event.InventoryCreated;
import co.com.sofka.ddd.domain.inventory.event.ProductAdded;
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
class AddProductUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddProductToInventory(){
        //arrange
        var aggregateID = "xxx-xxx";
        var command = new AddProduct(new InventoryID(aggregateID), new ProductID("kumara"), new ProductPrice(180000),
                new ProductName("KumaraK552"), new ProductState(0),new ProductQuanty(2));

        var useCase = new AddProductUseCase();

        Mockito.when(repository.getEventsBy(aggregateID)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert

        var eventCreation = (ProductAdded)events.get(0);

        Assertions.assertEquals("kumara", eventCreation.getProductID().value());
    }

    private List<DomainEvent> eventStored() {

        return List.of(
                new InventoryCreated(new InventoryID("xxx-xxx"),new OfficeID(), new OfficeName("Ibague"))
        );

    }

}