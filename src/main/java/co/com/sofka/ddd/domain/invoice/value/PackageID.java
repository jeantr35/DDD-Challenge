package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.Identity;

public class PackageID extends Identity {
    public PackageID(){
    }

    private PackageID(String id){
        super(id);
    }

    public static PackageID of(String id){
        return new PackageID(id);
    }
}
