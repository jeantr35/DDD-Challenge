package co.com.sofka.ddd.domain.inventory.command;

import co.com.sofka.domain.generic.Command;

public class UpdateOfficeName extends Command {

    private final String newName;

    public UpdateOfficeName(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }

}
