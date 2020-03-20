package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.SupplierRepository;
import com.example.demo.data.entities.Supplier;
import com.example.demo.service.api.SupplierService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private final SupplierRepository supplierRepository;

    @Autowired
    private final Gson gson;

    @Autowired
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliersToDatabase() {
        String file = FileUtil.readFile(FileImportPath.SUPPLIERS_FILE_PATH);

        List<Supplier> suppliers = gson.fromJson(file, new TypeToken<List<Supplier>>() {
        }.getType());

        if (suppliers != null) {
            suppliers.forEach(supplierRepository::saveAndFlush);
        }
    }

    @Override
    public Supplier getRandomSupplier() {
        int allSuppliersCount = supplierRepository.getAllSuppliersCount();

        Random random = new Random();

        long randomSupplierId = random.nextInt(allSuppliersCount) + 1;

        return supplierRepository.findById(randomSupplierId);
    }
}
