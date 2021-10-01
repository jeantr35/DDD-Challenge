package co.com.sofka.ddd.domain.invoice.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaymentMethod implements ValueObject<String> {

    private final String[] method = new String[]{"Credit Card", "Cash"};
    private final Integer value;

    public PaymentMethod(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value > 1 || this.value < 0){
            throw new IllegalArgumentException("Payment method should be 0 (Credit Card) or 1 (Cash)");
        }
    }

    @Override
    public String value() {
        return method[value];
    }
}
