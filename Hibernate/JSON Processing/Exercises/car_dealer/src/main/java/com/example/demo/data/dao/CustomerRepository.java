package com.example.demo.data.dao;

import com.example.demo.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);

    @Query("SELECT COUNT(c.id) FROM Customer c")
    int getAllCustomersCount();
}
