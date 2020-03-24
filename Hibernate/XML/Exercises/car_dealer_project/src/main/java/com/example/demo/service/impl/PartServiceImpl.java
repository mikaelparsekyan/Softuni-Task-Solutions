package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.PartRepository;
import com.example.demo.data.entities.Part;
import com.example.demo.dtos.import_dtos.part.PartsImportDto;
import com.example.demo.service.api.PartService;
import com.example.demo.service.api.SupplierService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service("partService")
public class PartServiceImpl implements PartService {
    @Autowired
    private final PartRepository partRepository;
    @Autowired
    private final SupplierService supplierService;
    @Autowired
    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedPartsToDatabase() {
        String file = FileUtil.readFile(FileImportPath.PARTS_FILE_PATH);

        PartsImportDto dto = XmlParser.deserialize(file,
                PartsImportDto.class);

        dto.getParts().forEach(part -> {
            part.setSupplier(supplierService.getRandomSupplier());
            partRepository.saveAndFlush(part);
        });
    }

    @Override
    public List<Part> getAllParts() {
        return partRepository.findAll();
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
