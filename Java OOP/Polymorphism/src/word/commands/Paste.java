package word.commands;

import word.interfaces.TextTransform;

public class Paste implements TextTransform {
    private Cut lastCutCommand;

    public Paste(Cut lastCutCommand) {
        this.lastCutCommand = lastCutCommand;
    }

    @Override
    public void invoke(StringBuilder text, int s, int e) {
        text.replace(s, e, lastCutCommand.getLastCut().toString());
    }

}
