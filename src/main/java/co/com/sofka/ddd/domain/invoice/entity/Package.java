package co.com.sofka.ddd.domain.invoice.entity;

import co.com.sofka.ddd.domain.invoice.value.PackageID;
import co.com.sofka.ddd.domain.invoice.value.PackageMaterial;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Package extends Entity<PackageID> {

    private PackageMaterial packageMaterial;

    public Package(PackageID entityId, PackageMaterial packageMaterial) {
        super(entityId);
        this.packageMaterial = packageMaterial;
    }

    public void updatePackageMatherial(Integer newMaterial){
        Objects.requireNonNull(newMaterial);
        this.packageMaterial = new PackageMaterial(newMaterial);
    }

    public PackageMaterial getPackageMaterial() {
        return packageMaterial;
    }
}
