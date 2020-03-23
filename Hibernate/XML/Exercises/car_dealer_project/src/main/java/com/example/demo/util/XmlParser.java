package com.example.demo.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class XmlParser {
    public static void serialize(Object object, String filePath) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            FileWriter result = new FileWriter(new File(filePath));
            marshaller.marshal(object, result);

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> T deserialize(String xml, Class<T> type) {
        T object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(type);

            Unmarshaller um = context.createUnmarshaller();

            object = (T) um.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }
}
