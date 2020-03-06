package spring.demo.spring1.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import spring.demo.spring1.domain.AccountService;
import spring.demo.spring1.domain.UserService;
import spring.demo.spring1.exception.IllegalBankOperationException;
import spring.demo.spring1.model.Account;
import spring.demo.spring1.model.User;

import java.math.BigDecimal;

@Component
@Slf4j
public class Runner implements ApplicationRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("George");
        User user2 = new User("John");

        Account account1 = new Account("accName", new BigDecimal(1000000));

        user1.getAccounts().add(account1);

        userService.registerUser(user1);

        log.info("!!! Initial balance: {}",
                accountService.getAccount(account1.getId()));
        accountService.withdrawMoney(account1.getId(), new BigDecimal(500));
        log.info("!!! Balance after withdrawal $500: {}",
                accountService.getAccount(account1.getId()));
        accountService.depositMoney(account1.getId(), new BigDecimal(200));
        log.info("!!! Balance after deposit $200: {}",
                accountService.getAccount(account1.getId()));

        try {
            accountService.transferMoney(account1.getId(), account1.getId(),
                    new BigDecimal(2000));
        } catch (IllegalBankOperationException e) {
            log.error(e.getMessage());
        }
        log.info("!!! Balance FROM after transfer $2000: {}",
                accountService.getAccount(account1.getId()));
        log.info("!!! Balance TO after transfer $2000: {}",
                accountService.getAccount(account1.getId()));
    }
}
