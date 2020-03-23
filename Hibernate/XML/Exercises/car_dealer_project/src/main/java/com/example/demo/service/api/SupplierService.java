package com.example.demo.service.api;

import com.example.demo.data.entities.Supplier;
import org.springframework.stereotype.Service;

@Service("supplierService")
public interface SupplierService {
    void seedSuppliersToDatabase();

    Supplier getRandomSupplier();

}
