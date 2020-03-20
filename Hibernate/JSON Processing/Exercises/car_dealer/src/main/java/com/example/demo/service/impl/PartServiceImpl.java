package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.PartRepository;
import com.example.demo.data.entities.Part;
import com.example.demo.service.api.PartService;
import com.example.demo.service.api.SupplierService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("partService")
public class PartServiceImpl implements PartService {
    @Autowired
    private final PartRepository partRepository;
    @Autowired
    private final SupplierService supplierService;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, Gson gson, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedPartsToDatabase() {
        String file = FileUtil.readFile(FileImportPath.PARTS_FILE_PATH);

        List<Part> parts = gson.fromJson(file, new TypeToken<List<Part>>() {
        }.getType());

        if (parts != null) {
            parts.forEach(part -> {
                part.setSupplier(supplierService.getRandomSupplier());
                partRepository.saveAndFlush(part);
            });
        }
    }

    @Override
    public Set<Part> getRandomParts(List<Part> allParts) {
        int allPartsCount = allParts.size();

        Random random = new Random();

        int randomPartsSize = random.nextInt(20 - 10) + 10;

        Set<Part> randomParts = new HashSet<>();
        for (int i = 0; i < randomPartsSize; i++) {
            int randomPartId = random.nextInt(allPartsCount);
            randomParts.add(allParts.get(randomPartId));

        }
        return randomParts;
    }
}
