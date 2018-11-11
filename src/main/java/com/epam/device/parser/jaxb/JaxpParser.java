package com.epam.device.parser.jaxb;

import com.epam.device.entity.Device;
import com.epam.device.entity.Devices;
import com.epam.device.exception.XmlParserException;
import com.epam.device.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxpParser implements Parser {

    @Override
    public List<Device> parse(String pathToFile) throws XmlParserException, JAXBException {
        Devices devices = (Devices) getObject(pathToFile, Devices.class);
        return devices.getList();
    }


    private Object getObject(String pathToFile, Class<?> c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(new File(pathToFile));
    }


}
