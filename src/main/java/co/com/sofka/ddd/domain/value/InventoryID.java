package co.com.sofka.ddd.domain.value;

import co.com.sofka.domain.generic.Identity;

public class InventoryID extends Identity {
    public InventoryID(){
    }

    private InventoryID(String id){
        super(id);
    }

    public static InventoryID of(String id){
        return new InventoryID(id);
    }
}
