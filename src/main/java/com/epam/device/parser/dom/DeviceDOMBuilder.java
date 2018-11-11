package com.epam.device.parser.dom;

import com.epam.device.entity.Device;
import com.epam.device.entity.XMLEnum;
import com.epam.device.entity.component.inner.InnerDevice;
import com.epam.device.entity.component.inner.InnerDevicePorts;
import com.epam.device.entity.component.outer.GroupOfOuterDevicePart;
import com.epam.device.entity.component.outer.OuterDevice;
import com.epam.device.entity.component.outer.OuterDevicePorts;
import com.epam.device.exception.XmlParserException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeviceDOMBuilder {
    private static final String nameValue = XMLEnum.NAME.getValue();
    private static final String idValue = XMLEnum.ID.getValue();
    private static final String portValue = XMLEnum.PORT.getValue();
    private static final String groupValue = XMLEnum.GROUP.getValue();
    private static final String withCoolerValue = XMLEnum.ISWITHCOOLER.getValue();
    private static final String priceValue = XMLEnum.PRICE.getValue();
    private static final String firmValue = XMLEnum.FIRM.getValue();
    private static final String powerConsumptionValue = XMLEnum.POWERCONSUMPTION.getValue();


    private static final Logger logger = Logger.getLogger(Logger.class);
    private List<Device> parts;
    private DocumentBuilder documentBuilder;


    public DeviceDOMBuilder() throws XmlParserException {

        parts = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlParserException(e);
        }
    }

    public List<Device> getParts() {
        return parts;
    }

    public void buildSetDevice(String fileName) {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            String innerDeviceValue = XMLEnum.INNERDEVICE.getValue();
            String outerDeviceValue = XMLEnum.OUTERDEVICE.getValue();
            NodeList innerComponent = root.getElementsByTagName(innerDeviceValue);
            NodeList outerComponent = root.getElementsByTagName(outerDeviceValue);

            for (int i = 0; i < innerComponent.getLength(); i++) {
                Element partElement = (Element) innerComponent.item(i);
                Device part = buildInnerDevice(partElement);
                parts.add(part);
            }
            for (int i = 0; i < outerComponent.getLength(); i++) {
                Element partElement = (Element) outerComponent.item(i);
                Device part = buildOuterDevice(partElement);
                parts.add(part);
            }
        } catch (SAXException | IOException e) {
            logger.warn(e);
        }
    }

    private Device buildOuterDevice(Element partElement) {

        OuterDevice computerPart = new OuterDevice();
        if (!"".equals(partElement.getAttribute(nameValue)) && !"".equals(partElement.getAttribute(idValue))) {
            computerPart.setName(partElement.getAttribute(nameValue));
            computerPart.setId(partElement.getAttribute(idValue));
        }

        String group = getElementTextContent(partElement, groupValue);
        computerPart.setGroup(GroupOfOuterDevicePart.valueOf(group));

        String port = getElementTextContent(partElement, portValue);
        computerPart.setPort(OuterDevicePorts.valueOf(port));

        return buildDevice(partElement, computerPart);
    }

    private Device buildInnerDevice(Element partElement) {
        InnerDevice computerPart = new InnerDevice();
        if (!"".equals(partElement.getAttribute(nameValue)) && !"".equals(partElement.getAttribute(idValue))) {
            computerPart.setName(partElement.getAttribute(nameValue));
            computerPart.setId(partElement.getAttribute(idValue));
        }
        computerPart.setWithCooler(Boolean.valueOf(getElementTextContent(partElement, withCoolerValue)));
        String port = getElementTextContent(partElement, portValue);
        computerPart.setPort(InnerDevicePorts.valueOf(port));
        return buildDevice(partElement, computerPart);
    }

    private Device buildDevice(Element partElement, Device computerPart) {
        computerPart.setFirm(getElementTextContent(partElement, firmValue));
        computerPart.setPrice(BigDecimal.valueOf(Long.parseLong(getElementTextContent(partElement, priceValue))));
        computerPart.setPowerConsumption(Integer.valueOf(getElementTextContent(partElement, powerConsumptionValue)));
        return computerPart;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
