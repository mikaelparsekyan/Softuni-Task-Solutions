package com.example.demo.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlParser {
    public static void serialize(Object object) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter result = new StringWriter();
            marshaller.marshal(object, result);

        } catch (JAXBException e) {
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
