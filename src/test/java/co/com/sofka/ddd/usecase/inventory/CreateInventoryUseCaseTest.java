package co.com.sofka.ddd.usecase.inventory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.domain.inventory.command.CreateInventory;
import co.com.sofka.ddd.domain.inventory.entity.Office;
import co.com.sofka.ddd.domain.inventory.event.InventoryCreated;
import co.com.sofka.ddd.domain.inventory.value.OfficeID;
import co.com.sofka.ddd.domain.inventory.value.OfficeName;
import co.com.sofka.ddd.domain.invoice.value.InventoryID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateInventoryUseCaseTest {

    @Test
    void CreateInventoryDefault(){
        //arrange
        var command = new CreateInventory(
                InventoryID.of("xxxx"),
                new Office(OfficeID.of("xxxx"), new OfficeName("Ibague"))
        );

        var useCase = new CreateInventoryUseCase();
        //act
        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert
        var eventCreation = (InventoryCreated)events.get(0);

        Assertions.assertEquals("Ibague", eventCreation.getOffice().getOfficeName().value());
        Assertions.assertEquals(0, eventCreation.getProducts().size());
        Assertions.assertEquals(0, eventCreation.getProviders().size());
        Assertions.assertEquals("xxxx", eventCreation.getOffice().identity().value());
    }


}