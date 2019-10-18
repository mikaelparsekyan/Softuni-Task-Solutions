package BankAccount;

public class BankAccount {
    private static int id = 0;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id++;
    }

    public int getId() {
        return id;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
