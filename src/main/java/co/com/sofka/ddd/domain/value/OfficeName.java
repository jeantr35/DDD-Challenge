package co.com.sofka.ddd.domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class OfficeName implements ValueObject<String> {


    private final String value;

    public OfficeName(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank() || this.value.length() < 6){
            throw new IllegalArgumentException("Office name length should be 6 or more");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
