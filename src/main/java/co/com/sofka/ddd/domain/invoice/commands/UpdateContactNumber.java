package co.com.sofka.ddd.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;

public class UpdateContactNumber extends Command {

    private final String newNumber;

    public UpdateContactNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public String getNewNumber() {
        return newNumber;
    }

}
