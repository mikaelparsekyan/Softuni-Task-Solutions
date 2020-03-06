package com.spring.project.spring.user_system.repositories;

import com.spring.project.spring.user_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByLastTimeLoggedInBefore(LocalDate date);

    List<User> getAllByEmailEndsWith(String email);

}
