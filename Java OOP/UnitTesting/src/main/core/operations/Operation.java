package tests.core.operations;

import tests.core.interfaces.Executable;

public abstract class Operation implements Executable {
    int a;
    int b;

    Operation(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
