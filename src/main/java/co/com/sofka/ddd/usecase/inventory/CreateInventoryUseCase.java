package co.com.sofka.ddd.usecase.inventory;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.CreateInventory;

public class CreateInventoryUseCase extends UseCase<RequestCommand<CreateInventory>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateInventory> createInventoryRequestCommand) {

        var command = createInventoryRequestCommand.getCommand();
        Inventory inventory;

        inventory = new Inventory(
                command.getInventoryID(),
                command.getOffice().identity(),
                command.getOffice().getOfficeName()
        );

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
