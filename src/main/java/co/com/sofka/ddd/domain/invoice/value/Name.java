package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank() || this.value.length() < 7){
            throw new IllegalArgumentException("Name length should be 7 or more");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
