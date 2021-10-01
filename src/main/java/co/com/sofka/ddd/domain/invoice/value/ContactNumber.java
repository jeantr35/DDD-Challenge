package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ContactNumber implements ValueObject<String> {

    private final String value;

    public ContactNumber(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank() || this.value.length() != 10){
            throw new IllegalArgumentException("Cellphone number length should be 10");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
