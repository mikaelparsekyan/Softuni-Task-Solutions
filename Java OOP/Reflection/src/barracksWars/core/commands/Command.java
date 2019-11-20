package barracksWars.core.commands;

import barracksWars.interfaces.Executable;

public abstract class Command implements Executable {

    protected String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }

}
