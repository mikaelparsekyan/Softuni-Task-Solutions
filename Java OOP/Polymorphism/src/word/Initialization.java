package word;

import word.interfaces.CommandInterface;

public class Initialization {
    public static CommandInterface generateCommandInterface(String text){
        return new CommandImpl(text);
    }
}
