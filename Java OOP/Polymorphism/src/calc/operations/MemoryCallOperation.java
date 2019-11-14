package calc.operations;

import calc.Operation;

import java.util.ArrayDeque;

public class MemoryCallOperation implements Operation {
    private ArrayDeque<Integer> memory;

    public MemoryCallOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        //empty
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

}
