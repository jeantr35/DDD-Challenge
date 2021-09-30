package co.com.sofka.ddd.domain.value;

import co.com.sofka.domain.generic.Identity;

public class InvoiceID extends Identity {
    public InvoiceID(){
    }

    private InvoiceID(String id){
        super(id);
    }

    public static InvoiceID of(String id){
        return new InvoiceID(id);
    }
}
