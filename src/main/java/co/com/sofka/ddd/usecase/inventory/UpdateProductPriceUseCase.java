package co.com.sofka.ddd.usecase.inventory;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.UpdateProductPrice;

public class UpdateProductPriceUseCase extends UseCase<RequestCommand<UpdateProductPrice>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateProductPrice> updateProductPriceRequestCommand) {

        var command = updateProductPriceRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        inventory.updateProductPrice(command.getProductID(), command.getNewPrice());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
