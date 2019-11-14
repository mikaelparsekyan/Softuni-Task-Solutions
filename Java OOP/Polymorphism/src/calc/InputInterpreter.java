package calc;

import calc.operations.DivisionOperation;
import calc.operations.MemoryCallOperation;
import calc.operations.MemorySaveOperation;
import calc.operations.MultiplicationOperation;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return new MemorySaveOperation(memory);
        } else if (operation.equals("mr")) {
            return new MemoryCallOperation(memory);
        }

        return null;
    }
}
