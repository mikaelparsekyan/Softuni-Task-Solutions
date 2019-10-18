package BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> accountMap = new LinkedHashMap<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    int id = account.getId();
                    accountMap.put(id, account);
                    System.out.printf("Account ID%d created%n", id);
                    break;
                case "Deposit":
                    int depositId = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    BankAccount bankAccount = accountMap.get(depositId);
                    if (bankAccount != null) {
                        bankAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, depositId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    int interestId = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount account1 = accountMap.get(interestId);
                    if(account1!=null) {
                        double interestRate = BankAccount.getInterestRate();
                        System.out.printf("%.2f%n", interestRate * account1.getBalance() * years);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
