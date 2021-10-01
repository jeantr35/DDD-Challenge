package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.Identity;

public class ProviderID extends Identity {

    public ProviderID(){
    }

    private ProviderID(String id){
        super(id);
    }

    public static ProviderID of(String id){
        return new ProviderID(id);
    }

}
