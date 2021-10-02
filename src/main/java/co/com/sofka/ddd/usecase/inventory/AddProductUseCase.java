package co.com.sofka.ddd.usecase.inventory;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.domain.inventory.Inventory;
import co.com.sofka.ddd.domain.inventory.command.AddProduct;


public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {

        var command = addProductRequestCommand.getCommand();
        Inventory inventory;
        inventory = Inventory.from(command.getInventoryID(),retrieveEvents(command.getInventoryID().value()));

        inventory.addProduct(command.getProductID(), command.getProductPrice(), command.getProductName(), command.getProductState(), command.getProductQuanty());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
