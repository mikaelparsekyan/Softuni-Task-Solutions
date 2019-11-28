package tests.core.operations;

public class Add extends Operation {
    public Add(int a, int b) {
        super(a, b);
    }

    @Override
    public int execute() {
        return a + b;
    }
}
