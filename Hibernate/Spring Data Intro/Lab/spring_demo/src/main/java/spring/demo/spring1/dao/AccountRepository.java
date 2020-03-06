package spring.demo.spring1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.spring1.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
}
