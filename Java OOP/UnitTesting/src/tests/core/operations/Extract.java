package tests.core.operations;

public class Extract extends Operation{
    public Extract(int a, int b) {
        super(a, b);
    }

    @Override
    public int execute() {
        return a - b;
    }
}
