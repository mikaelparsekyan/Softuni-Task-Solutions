package hiberspring.service.impl;

import hiberspring.domain.dto.ProductsImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hiberspring.constants.FileImportPath.PRODUCTS_IMPORT_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final XmlParser xmlParser;
    @Autowired
    private final BranchService branchService;
    @Autowired
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, XmlParser xmlParser, BranchService branchService, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_IMPORT_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        StringBuilder result = new StringBuilder();
        ProductsImportDto importDto = xmlParser
                .parseXml(ProductsImportDto.class, PRODUCTS_IMPORT_PATH);

        importDto.getProducts()
                .forEach(dto -> {
                    Product product = modelMapper.map(dto, Product.class);
                    Branch branch = branchService.getBranchByName(dto.getBranch());
                    if (branch != null) {
                        product.setBranch(branch);
                        if (validationUtil.isValid(product) &&
                                validationUtil.isValid(branch)) {
                            productRepository.saveAndFlush(product);
                            result.append(String.format("Successfully imported Product %s.",
                                    product.getName()));
                        } else {
                            result.append("Error: Invalid data.");
                        }
                    } else {
                        result.append("Branch not in db!");
                    }
                    result.append(System.lineSeparator());
                });

        return result.toString();
    }
}
