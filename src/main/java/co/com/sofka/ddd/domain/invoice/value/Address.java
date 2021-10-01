package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<String> {

    private final String value;

    public Address(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank() || this.value.length() < 6){
            throw new IllegalArgumentException("Address length should be 6 or more");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
