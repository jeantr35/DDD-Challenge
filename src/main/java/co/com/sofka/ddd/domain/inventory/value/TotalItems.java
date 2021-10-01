package co.com.sofka.ddd.domain.inventory.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TotalItems implements ValueObject<Integer> {

    private final Integer value;

    public TotalItems(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("Total items cant be lower than 0");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

}
