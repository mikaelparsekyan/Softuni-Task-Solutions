package com.example.project.data.repositories;

import com.example.project.data.entities.Order;
import com.example.project.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getOrdersByBuyer(User buyer);

    void deleteOrderById(long id);

}
