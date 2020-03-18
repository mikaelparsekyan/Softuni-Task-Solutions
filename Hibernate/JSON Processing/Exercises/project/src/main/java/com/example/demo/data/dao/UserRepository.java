package com.example.demo.data.dao;

import com.example.demo.data.entiites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT COUNT(u.id) FROM User u")
    int getAllUsersCount();

    User findById(long id);

}
