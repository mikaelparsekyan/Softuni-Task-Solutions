package com.example.demo.data.dao;

import com.example.demo.data.entities.Car;
import com.example.demo.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);

    @Query("SELECT COUNT(c.id) FROM Customer c")
    int getAllCustomersCount();

    @Query("SELECT ca FROM Customer c JOIN " +
            "c.sale s JOIN s.car ca WHERE c.id = :id GROUP BY ca.id")
    Set<Car> getAllCarsByCustomer(@Param("id") long id);

}
