package com.github.sowmz.kigener.enterprise.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SimpleConversion {

    public static <T> T getClass(String configFile, T obj){
        T newObj=null;

        File file = new File(configFile);
        JAXBContext jaxbContext = null;
        Unmarshaller jaxbContextUnmarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance(obj.getClass());
            jaxbContextUnmarshaller = jaxbContext.createUnmarshaller();

            newObj = (T) jaxbContextUnmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return newObj;

    }
}
