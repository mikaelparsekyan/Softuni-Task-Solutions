package com.example.demo.data.dao;

import com.example.demo.data.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT COUNT (c.id) FROM Car c")
    int getAllCarsCount();

    Car findById(long id);

    List<Car> getCarsByMake(String make);
}
