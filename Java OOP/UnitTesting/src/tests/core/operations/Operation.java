package tests.core.operations;

import tests.core.interfaces.Executable;

public abstract class Operation implements Executable {
    protected int a;
    protected int b;

    protected Operation(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
