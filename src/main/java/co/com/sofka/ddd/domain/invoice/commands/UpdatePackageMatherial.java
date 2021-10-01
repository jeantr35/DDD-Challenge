package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdatePackageMatherial extends Command {
    private final Integer newMaterial;

    public UpdatePackageMatherial(Integer newMaterial) {
        this.newMaterial = newMaterial;
    }

    public Integer getNewMaterial() {
        return newMaterial;
    }
}
