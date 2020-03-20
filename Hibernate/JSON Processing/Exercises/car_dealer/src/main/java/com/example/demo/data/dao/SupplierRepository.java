package com.example.demo.data.dao;

import com.example.demo.data.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findById(long id);

    @Query("SELECT COUNT(s.id) FROM Supplier s")
    int getAllSuppliersCount();
}
