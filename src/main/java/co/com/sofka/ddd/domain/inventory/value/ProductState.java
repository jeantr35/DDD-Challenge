package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductState implements ValueObject<String> {

    private final String[] materials = new String[]{"New", "Used"};
    private final Integer value;

    public ProductState(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value > 1 || this.value < 0){
            throw new IllegalArgumentException("Product state should be 0 (New) or 1 (Used)");
        }
    }

    @Override
    public String value() {
        return materials[value];
    }
}
