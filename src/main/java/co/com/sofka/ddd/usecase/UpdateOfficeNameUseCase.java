package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.UpdateOfficeName;

public class UpdateOfficeNameUseCase extends UseCase<RequestCommand<UpdateOfficeName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOfficeName> updateOfficeNameRequestCommand) {

        var command = updateOfficeNameRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        inventory.updateOfficeName(command.getNewName());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }

}
