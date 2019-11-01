package stackOfStrings;


import java.util.LinkedList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new LinkedList<>();
    }

    public void push(String e) {
        this.data.add(e);
    }

    public String pop() {
        String value = this.data.get(this.data.size() - 1);
        this.data.remove(value);
        return value;
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
