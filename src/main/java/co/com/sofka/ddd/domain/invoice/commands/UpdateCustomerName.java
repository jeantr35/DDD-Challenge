package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdateCustomerName extends Command {

    private final String newName;

    public UpdateCustomerName(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
}
