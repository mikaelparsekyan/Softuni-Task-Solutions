package alararestaurant.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public interface XmlParser {

    <T> T convertFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;

}
