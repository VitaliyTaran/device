package com.epam.device.parser.sax;

import com.epam.device.entity.Device;
import com.epam.device.entity.XMLEnum;
import com.epam.device.entity.component.inner.InnerDevice;
import com.epam.device.entity.component.inner.InnerDevicePorts;
import com.epam.device.entity.component.outer.GroupOfOuterDevicePart;
import com.epam.device.entity.component.outer.OuterDevice;
import com.epam.device.entity.component.outer.OuterDevicePorts;
import com.epam.device.exception.IncorrectTypeException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SaxDeviceHandler extends DefaultHandler {
    private List<Device> parts;
    private Device current;
    private InnerDevice innerPart;
    private OuterDevice outerPart;
    private XMLEnum currentEnum;
    private EnumSet<XMLEnum> rangeEnumValue;
    private InnerDevicePorts[] innerPorts = InnerDevicePorts.values();
    private OuterDevicePorts[] outerPorts = OuterDevicePorts.values();


    public SaxDeviceHandler() {
        parts = new ArrayList<>();
        rangeEnumValue = EnumSet.range(XMLEnum.NAME, XMLEnum.PORT);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String innerComponentValue = XMLEnum.INNERDEVICE.getValue();
        String outerComponentValue = XMLEnum.OUTERDEVICE.getValue();
        if (innerComponentValue.equals(localName) || outerComponentValue.equals(localName)) {
            current = new Device();
            current.setId(attributes.getValue(0));
            current.setName(attributes.getValue(1));
        } else {

            XMLEnum temp = convertIntoXMLEnum(localName);
            if (rangeEnumValue.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case FIRM:
                    current.setFirm(s);
                    break;
                case PRICE:
                    current.setPrice(BigDecimal.valueOf(Long.parseLong(s)));
                    break;
                case POWERCONSUMPTION:
                    current.setPowerConsumption(Integer.parseInt(s));
                    break;
                case ISWITHCOOLER:
                    innerPart = new InnerDevice(current);
                    innerPart.setWithCooler(Boolean.valueOf(s));
                    break;
                case GROUP:
                    outerPart = new OuterDevice(current);
                    outerPart.setGroup(GroupOfOuterDevicePart.valueOf(s));
                    break;
                case PORT:
                    if (isContain(innerPorts, s)) {
                        innerPart.setPort(InnerDevicePorts.valueOf(s));
                        current = null;
                        outerPart = null;
                    }
                    if (isContain(outerPorts, s)) {
                        outerPart.setPort(OuterDevicePorts.valueOf(s));
                        innerPart = null;
                        current = null;
                    }
                    break;
            }
            currentEnum = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (XMLEnum.PORT.getValue().equals(localName)) {
            if (outerPart == null) {
                parts.add(innerPart);
            } else {
                parts.add(outerPart);
            }
        }
    }

    public List<Device> getParts() {
        return parts;
    }

    private boolean isContain(Enum[] enums, String string) {
        for (Enum e : enums) {
            String enumString = e.toString();
            if (enumString.equals(string)) {
                return true;
            }
        }
        return false;
    }

    private XMLEnum convertIntoXMLEnum(String localName) {
        XMLEnum[] values = XMLEnum.values();
        for (XMLEnum e : values) {
            if (e.getValue().equals(localName)) {
                return e;
            }
        }
        return null;
    }
}