package com.epam.device.parser.sax;

import com.epam.device.entity.Device;
import com.epam.device.exception.XmlParserException;
import com.epam.device.parser.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<Device> parse(String pathToFile) throws XmlParserException, SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxDeviceHandler handler = new SaxDeviceHandler();
        reader.setContentHandler(handler);
        reader.parse(pathToFile);
        return handler.getParts();
    }
}
