package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.SupplierRepository;
import com.example.demo.data.entities.Supplier;
import com.example.demo.dtos.export_dtos.supplier.ExportLocalSuppliersDto;
import com.example.demo.dtos.export_dtos.supplier.SuppliersAttributeInfoDto;
import com.example.demo.dtos.import_dtos.supplier.SuppliersImportDto;
import com.example.demo.service.api.SupplierService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private final SupplierRepository supplierRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliersToDatabase() {
        String file = FileUtil.readFile(FileImportPath.SUPPLIERS_FILE_PATH);

        SuppliersImportDto dto = XmlParser.deserialize(file,
                SuppliersImportDto.class);

        dto.getSuppliers().forEach(supplierRepository::saveAndFlush);
    }

    @Override
    public Supplier getRandomSupplier() {
        int allSuppliersCount = supplierRepository.getAllSuppliersCount();

        Random random = new Random();

        long randomSupplierId = random.nextInt(allSuppliersCount) + 1;

        return supplierRepository.findById(randomSupplierId);
    }

    @Override
    public void exportAllLocalSuppliers() {
        List<SuppliersAttributeInfoDto> suppliers = supplierRepository
                .findAll()
                .stream()
                .filter(supplier -> !supplier.isImporter())
                .map(supplier -> {
                    SuppliersAttributeInfoDto dto = modelMapper.map(supplier,
                            SuppliersAttributeInfoDto.class);
                    dto.setPartsCount(supplierRepository.getPartsCountBySupplierId(
                            supplier.getId()));
                    return dto;
                }).collect(Collectors.toList());

        ExportLocalSuppliersDto dto = new ExportLocalSuppliersDto();
        dto.setSuppliers(suppliers);

        XmlParser.serialize(dto, FileExportPath.SUPPLIERS_FILE_PATH);
    }
}
