package co.com.sofka.ddd.domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductQuanty implements ValueObject<Integer> {

    private final Integer value;

    public ProductQuanty(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("Product quanty cant be lower than 0");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

}
