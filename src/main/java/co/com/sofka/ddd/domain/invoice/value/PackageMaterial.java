package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PackageMaterial implements ValueObject<String> {

    private final String[] materials = new String[]{"Plastic", "Paperboard"};
    private final Integer value;

    public PackageMaterial(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value > 1 || this.value < 0){
            throw new IllegalArgumentException("Package material should be 0 (Plastic) or 1 (Paperboard)");
        }
    }

    @Override
    public String value() {
        return materials[value];
    }

}
