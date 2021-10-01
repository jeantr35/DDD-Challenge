package co.com.sofka.ddd.domain.inventory.entity;

import co.com.sofka.ddd.domain.inventory.value.OfficeID;
import co.com.sofka.ddd.domain.inventory.value.OfficeName;
import co.com.sofka.domain.generic.Entity;

public class Office extends Entity<OfficeID> {

    private OfficeName officeName;

    public Office(OfficeID entityId, OfficeName officeName) {
        super(entityId);
        this.officeName = officeName;
    }

    public OfficeName getOfficeName() {
        return officeName;
    }

    public void updateName(String newName){
        this.officeName = new OfficeName(newName);
    }

}
