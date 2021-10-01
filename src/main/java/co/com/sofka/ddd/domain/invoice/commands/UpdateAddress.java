package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdateAddress extends Command {
    private final String newAddress;

    public UpdateAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }
}
