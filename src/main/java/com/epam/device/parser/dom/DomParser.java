package com.epam.device.parser.dom;

import com.epam.device.entity.Device;
import com.epam.device.exception.XmlParserException;
import com.epam.device.parser.Parser;

import java.util.List;

public class DomParser implements Parser {

    @Override
    public List<Device> parse(String pathToFile) throws XmlParserException {
        DeviceDOMBuilder domBuilder = new DeviceDOMBuilder();
        domBuilder.buildSetDevice(pathToFile);
        return domBuilder.getParts();
    }
}
