package hiberspring.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface ProductService {

    Boolean productsAreImported();

    String readProductsXmlFile() throws IOException;

    String importProducts() throws JAXBException, FileNotFoundException;
}
