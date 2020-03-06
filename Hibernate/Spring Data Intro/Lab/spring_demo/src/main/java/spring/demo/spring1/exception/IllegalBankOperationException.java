package spring.demo.spring1.exception;

public class IllegalBankOperationException extends RuntimeException {
    public IllegalBankOperationException() {
        super();
    }

    public IllegalBankOperationException(String message) {
        super(message);
    }
}
