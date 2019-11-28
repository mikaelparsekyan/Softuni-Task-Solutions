package tests.core;

import tests.core.input_reader.Input;
import tests.core.operations.Add;
import tests.core.operations.Extract;
import tests.core.operations.Operation;
import tests.core.validator.Validator;

public class Engine implements Runnable {

    @Override
    public void run() {
        try {
            init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void init() {
        Input reader = new Input();
        String[] expression = reader.getNextLine("\\s+");

        for (int i = 0; i < expression.length - 2; i += 2) {
            //FIXME - implements the right methods!
            String a = expression[i];
            String b = expression[i + 2];
            Validator.validateNumber(a);
            Validator.validateNumber(b);

            int num1 = Integer.parseInt(expression[i]);
            String operator = expression[i + 1];
            int num2 = Integer.parseInt(expression[i + 2]);

            Validator.validateOperator(operator);
            Operation currentOperation = getOperation(num1, num2, operator);



            System.out.println(currentOperation.execute());
        }
    }

    private Operation getOperation(int a, int b, String element) {
        Operation operation = null;
        switch (element) {
            case "-":
                operation = new Extract(a, b);
                break;
            case "+":
                operation = new Add(a, b);
                break;
        }
        return operation;
    }
}
