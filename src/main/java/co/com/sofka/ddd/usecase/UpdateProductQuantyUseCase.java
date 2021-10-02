package co.com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.UpdateProductQuanty;

public class UpdateProductQuantyUseCase extends UseCase<RequestCommand<UpdateProductQuanty>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateProductQuanty> updateProductQuantyRequestCommand) {

        var command = updateProductQuantyRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        if (!command.isAddQuanty() && command.getQuanty() > inventory.getProductById(command.getProduct()).get().getProductQuanty().value()){
            throw new IllegalArgumentException("Subtract quanty cant be greater than the actual quanty");
        }
        inventory.updateProductQuanty(command.getProduct(), command.getQuanty(), command.isAddQuanty());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
