package hiberspring.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public interface XmlParser {

    <T> T parseXml(Class<T> objectClass, String filePath) throws JAXBException, FileNotFoundException;
}
