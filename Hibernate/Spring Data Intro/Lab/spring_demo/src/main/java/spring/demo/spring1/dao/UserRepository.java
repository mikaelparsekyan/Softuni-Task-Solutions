package spring.demo.spring1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.spring1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
