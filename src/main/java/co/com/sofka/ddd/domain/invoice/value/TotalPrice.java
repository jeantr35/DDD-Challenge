package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TotalPrice implements ValueObject<Integer> {
    private final Integer value;

    public TotalPrice(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0){
            throw new IllegalArgumentException("Price should be greater than 0");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
