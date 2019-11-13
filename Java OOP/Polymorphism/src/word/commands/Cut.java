package word.commands;

import word.interfaces.TextTransform;

public class Cut implements TextTransform {
    private StringBuilder lastCut;

    @Override
    public void invoke(StringBuilder text, int s, int e) {
        this.lastCut = new StringBuilder();
        this.lastCut.append(text, s, e);
        text.delete(s, e);
    }

    protected StringBuilder getLastCut() {
        return lastCut;
    }
}
