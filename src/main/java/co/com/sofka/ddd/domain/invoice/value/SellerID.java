package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.Identity;

public class SellerID extends Identity {

    public SellerID(){
    }

    private SellerID(String id){
        super(id);
    }

    public static SellerID of(String id){
        return new SellerID(id);
    }

}
