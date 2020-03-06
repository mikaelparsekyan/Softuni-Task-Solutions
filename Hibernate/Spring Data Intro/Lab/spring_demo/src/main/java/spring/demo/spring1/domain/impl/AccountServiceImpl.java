package spring.demo.spring1.domain.impl;

import org.springframework.stereotype.Service;
import spring.demo.spring1.dao.AccountRepository;
import spring.demo.spring1.domain.AccountService;
import spring.demo.spring1.exception.IllegalBankOperationException;
import spring.demo.spring1.model.Account;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(long id) {
        return accountRepository.findById(id);
    }
    @Transactional
    @Override
    public void withdrawMoney(long id, BigDecimal amount) {
        Account account = getAccount(id);

        BigDecimal currentBalance = getAccount(id).getBalance();

        if (currentBalance.compareTo(amount) < 0) {
            throw new IllegalBankOperationException("Unsupported operation: Cannot subtract from your balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        System.out.println("Successful withdraw!");
        System.out.println("Current balance: " + account.getBalance());
        System.out.println("Withdraw amount: " + amount);
        accountRepository.save(account);
    }
    @Transactional
    @Override
    public void depositMoney(long id, BigDecimal amount) {
        Account account = getAccount(id);

        account.setBalance(account.getBalance().add(amount));
        System.out.println("Successful deposit!");
        System.out.println("Current balance: " + account.getBalance());
        System.out.println("Deposit amount: " + amount);
        accountRepository.save(account);
    }
    @Transactional
    @Override
    public void transferMoney(long fromId, long toId, BigDecimal amount) {
        withdrawMoney(fromId, amount);
        depositMoney(toId, amount);
    }
}
