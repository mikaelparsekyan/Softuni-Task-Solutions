package word.commands;

import word.interfaces.TextTransform;

public class Uppercase implements TextTransform {

    @Override
    public void invoke(StringBuilder text, int s, int e) {
        text.replace(s, e, text.substring(s, e).toUpperCase());
    }
}
