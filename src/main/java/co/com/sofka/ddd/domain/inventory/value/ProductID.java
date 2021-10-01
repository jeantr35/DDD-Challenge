package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.Identity;

public class ProductID extends Identity {
    public ProductID(){
    }

    private ProductID(String id){
        super(id);
    }

    public static ProductID of(String id){
        return new ProductID(id);
    }

}
