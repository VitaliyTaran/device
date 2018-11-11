package parser.dom;


import com.epam.device.entity.Device;
import com.epam.device.exception.IncorrectTypeException;
import com.epam.device.exception.XmlParserException;
import com.epam.device.parser.Parser;
import com.epam.device.parser.dom.DomParser;
import com.epam.device.parser.factory.ParserFactory;
import com.epam.device.parser.factory.TypeOfParser;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import parser.TestUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DomParserTest {
    private static final Logger logger = Logger.getLogger(Logger.class);

    @Test
    public void parserTest() {
        //Given
        List<Device> list = new ArrayList<>();
        List<Device> devices = TestUtil.giveListDevices();
        ParserFactory factory = new ParserFactory();
        Parser parser = null;
        try {
            parser = factory.createParser(TypeOfParser.DOM);
        } catch (IncorrectTypeException e) {
            logger.warn(e);
        }
        //When
        try {
            assert parser != null;
            list = parser.parse(TestUtil.getPartToFile());

        } catch (XmlParserException | IOException | JAXBException | SAXException e) {
            logger.warn(e);
        }
        //Then
        Assert.assertEquals(devices.get(0).getId(), list.get(0).getId());
        Assert.assertEquals(devices.get(0).getName(), list.get(0).getName());
        Assert.assertEquals(devices.get(0).getFirm(), list.get(0).getFirm());
        Assert.assertEquals(devices.get(0).getPrice(), list.get(0).getPrice());
        Assert.assertEquals(devices.get(0).getPowerConsumption(), list.get(0).getPowerConsumption());
        Assert.assertEquals(devices.get(0), list.get(0));

        Assert.assertEquals(devices.get(1).getId(), list.get(1).getId());
        Assert.assertEquals(devices.get(1).getName(), list.get(1).getName());
        Assert.assertEquals(devices.get(1).getFirm(), list.get(1).getFirm());
        Assert.assertEquals(devices.get(1).getPrice(), list.get(1).getPrice());
        Assert.assertEquals(devices.get(1).getPowerConsumption(), list.get(1).getPowerConsumption());
        Assert.assertEquals(devices.get(1), list.get(1));

        Assert.assertEquals(devices.get(2).getId(), list.get(2).getId());
        Assert.assertEquals(devices.get(2).getName(), list.get(2).getName());
        Assert.assertEquals(devices.get(2).getFirm(), list.get(2).getFirm());
        Assert.assertEquals(devices.get(2).getPrice(), list.get(2).getPrice());
        Assert.assertEquals(devices.get(2).getPowerConsumption(), list.get(2).getPowerConsumption());
        Assert.assertEquals(devices.get(2), list.get(2));

        Assert.assertEquals(devices.get(3).getId(), list.get(3).getId());
        Assert.assertEquals(devices.get(3).getName(), list.get(3).getName());
        Assert.assertEquals(devices.get(3).getFirm(), list.get(3).getFirm());
        Assert.assertEquals(devices.get(3).getPrice(), list.get(3).getPrice());
        Assert.assertEquals(devices.get(3).getPowerConsumption(), list.get(3).getPowerConsumption());
        Assert.assertEquals(devices.get(3), list.get(3));

        Assert.assertEquals(devices.get(4).getId(), list.get(4).getId());
        Assert.assertEquals(devices.get(4).getName(), list.get(4).getName());
        Assert.assertEquals(devices.get(4).getFirm(), list.get(4).getFirm());
        Assert.assertEquals(devices.get(4).getPrice(), list.get(4).getPrice());
        Assert.assertEquals(devices.get(4).getPowerConsumption(), list.get(4).getPowerConsumption());
        Assert.assertEquals(devices.get(4), list.get(4));

        Assert.assertEquals(devices.get(5).getId(), list.get(5).getId());
        Assert.assertEquals(devices.get(5).getName(), list.get(5).getName());
        Assert.assertEquals(devices.get(5).getFirm(), list.get(5).getFirm());
        Assert.assertEquals(devices.get(5).getPrice(), list.get(5).getPrice());
        Assert.assertEquals(devices.get(5).getPowerConsumption(), list.get(5).getPowerConsumption());
        Assert.assertEquals(devices.get(5), list.get(5));

        Assert.assertEquals(devices.get(6).getId(), list.get(6).getId());
        Assert.assertEquals(devices.get(6).getName(), list.get(6).getName());
        Assert.assertEquals(devices.get(6).getFirm(), list.get(6).getFirm());
        Assert.assertEquals(devices.get(6).getPrice(), list.get(6).getPrice());
        Assert.assertEquals(devices.get(6).getPowerConsumption(), list.get(6).getPowerConsumption());
        Assert.assertEquals(devices.get(6), list.get(6));

        Assert.assertEquals(devices.get(7).getId(), list.get(7).getId());
        Assert.assertEquals(devices.get(7).getName(), list.get(7).getName());
        Assert.assertEquals(devices.get(7).getFirm(), list.get(7).getFirm());
        Assert.assertEquals(devices.get(7).getPrice(), list.get(7).getPrice());
        Assert.assertEquals(devices.get(7).getPowerConsumption(), list.get(7).getPowerConsumption());
        Assert.assertEquals(devices.get(7), list.get(7));

        Assert.assertEquals(devices.get(8).getId(), list.get(8).getId());
        Assert.assertEquals(devices.get(8).getName(), list.get(8).getName());
        Assert.assertEquals(devices.get(8).getFirm(), list.get(8).getFirm());
        Assert.assertEquals(devices.get(8).getPrice(), list.get(8).getPrice());
        Assert.assertEquals(devices.get(8).getPowerConsumption(), list.get(8).getPowerConsumption());
        Assert.assertEquals(devices.get(8), list.get(8));

        Assert.assertEquals(devices.get(9).getId(), list.get(9).getId());
        Assert.assertEquals(devices.get(9).getName(), list.get(9).getName());
        Assert.assertEquals(devices.get(9).getFirm(), list.get(9).getFirm());
        Assert.assertEquals(devices.get(9).getPrice(), list.get(9).getPrice());
        Assert.assertEquals(devices.get(9).getPowerConsumption(), list.get(9).getPowerConsumption());
        Assert.assertEquals(devices.get(9), list.get(9));

    }
}
