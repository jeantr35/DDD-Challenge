package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdateSellerName extends Command {
    private final String newName;

    public UpdateSellerName(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }

}
