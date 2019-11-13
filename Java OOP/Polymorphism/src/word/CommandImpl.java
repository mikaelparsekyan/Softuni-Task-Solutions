package word;

import word.commands.Cut;
import word.commands.Paste;
import word.commands.Uppercase;
import word.interfaces.CommandInterface;
import word.interfaces.TextTransform;

public class CommandImpl implements CommandInterface {
    private StringBuilder text;
    private Cut lastCut;

    public CommandImpl(String text) {
        this.text = new StringBuilder(text);
        this.lastCut = new Cut();
    }
    @Override
    public void readInput(String input) {
        String[] elements = input.split("\\s+");
        String command = elements[0];
        TextTransform operation = null;
        switch (command) {
            case "cut":
                Cut currentCut = new Cut();
                operation = currentCut;
                lastCut = currentCut;
                break;
            case "paste":
                operation = new Paste(lastCut);
                break;
            case "uppercase":
                operation = new Uppercase();
                break;
        }
        if (operation != null) {
            operation.invoke(text, Integer.parseInt(elements[1]),
                    Integer.parseInt(elements[2]));
        }
    }

    @Override
    public StringBuilder getText() {
        return text;
    }
}
