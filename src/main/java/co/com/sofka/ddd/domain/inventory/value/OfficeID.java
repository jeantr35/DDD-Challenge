package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.Identity;

public class OfficeID extends Identity {

    public OfficeID(){
    }

    private OfficeID(String id){
        super(id);
    }

    public static OfficeID of(String id){
        return new OfficeID(id);
    }

}
