package com.example.demo.data.dao;

import com.example.demo.data.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findById(long id);

    @Query("SELECT COUNT(s.id) FROM Supplier s")
    int getAllSuppliersCount();

    @Query("SELECT COUNT(p.id) FROM Part p JOIN p.supplier s WHERE s.id = :id")
    long getPartsCountBySupplierId(@Param("id") long id);
}
