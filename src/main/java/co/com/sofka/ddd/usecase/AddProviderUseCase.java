package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.AddProvider;
import co.com.sofka.ddd.domain.inventory.command.UpdateProductQuanty;

public class AddProviderUseCase extends UseCase<RequestCommand<AddProvider>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProvider> addProviderRequestCommand) {
        var command = addProviderRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        inventory.addProvider(command.getProviderID(), command.getTotalItems());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
