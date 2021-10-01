package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductName implements ValueObject<String> {

    private final String value;

    public ProductName(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank() || this.value.length() < 7){
            throw new IllegalArgumentException("Product name length should be 7 or more");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
