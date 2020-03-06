package spring.demo.spring1.domain;

import spring.demo.spring1.model.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account getAccount(long id);

    void withdrawMoney(long id, BigDecimal amount);

    void depositMoney(long id, BigDecimal amount);

    void transferMoney(long fromId, long toId, BigDecimal amount);
}
