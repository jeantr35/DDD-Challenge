package co.com.sofka.ddd.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PackageMaterialUpdated extends DomainEvent {

    private final Integer newMaterial;

    public PackageMaterialUpdated(Integer newMaterial) {
        super("sofka.domain.invoice.packagematherialupdated");
        this.newMaterial = newMaterial;
    }

    public Integer getNewMaterial() {
        return newMaterial;
    }
}
