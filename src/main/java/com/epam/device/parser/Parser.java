package com.epam.device.parser;

import com.epam.device.entity.Device;
import com.epam.device.exception.XmlParserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface Parser {
    public List<Device> parse(String pathToFile) throws XmlParserException, JAXBException, SAXException, IOException;
}
