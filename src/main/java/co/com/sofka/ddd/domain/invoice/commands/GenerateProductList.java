package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.ddd.domain.inventory.value.ProductID;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class GenerateProductList extends Command {


    private final List<ProductID> productIDS;

    public GenerateProductList(List<ProductID> productIDS) {
        this.productIDS = productIDS;
    }

    public List<ProductID> getProductIDS() {
        return productIDS;
    }

}
