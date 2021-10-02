package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.UpdateProductName;

public class UpdateProductNameUSeCase extends UseCase<RequestCommand<UpdateProductName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateProductName> updateProductNameRequestCommand) {

        var command = updateProductNameRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        inventory.updateProductNmae(command.getProduct().identity(), command.getNewName());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
