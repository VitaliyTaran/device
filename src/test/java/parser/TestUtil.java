package parser;

import com.epam.device.entity.Device;
import com.epam.device.entity.component.inner.InnerDevice;
import com.epam.device.entity.component.outer.OuterDevice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.epam.device.entity.component.inner.InnerDevicePorts.*;
import static com.epam.device.entity.component.outer.GroupOfOuterDevicePart.INPUT_OUTPUT_DEVICE;
import static com.epam.device.entity.component.outer.GroupOfOuterDevicePart.MULTIMEIDA;
import static com.epam.device.entity.component.outer.OuterDevicePorts.*;

public class TestUtil {

    private static final String PART_TO_SCHEMA = "./src/main/resources/file-schema.xsd";
    private static final String PART_TO_FILE = "./src/main/resources/file.xml";


    public static List<Device> giveListDevices() {
        Device first = new InnerDevice("ID-1", "CPU", "Intel", BigDecimal.valueOf(300), 75, true, SOCKET);
        Device second = new InnerDevice("ID-2", "Main Card", "MSI", BigDecimal.valueOf(100), 10, false, PCI_EXPRESS);
        Device third = new InnerDevice("ID-3", "Ram", "ASUS", BigDecimal.valueOf(160), 10, false, DIMM);
        Device fourth = new InnerDevice("ID-4", "Rom (hdd)", "Barracuda", BigDecimal.valueOf(90), 10, false, SATA);
        Device fifth = new InnerDevice("ID-5", "Rom (ssd)", "Kingston", BigDecimal.valueOf(100), 3, false, M_TWO);
        Device sixth = new OuterDevice("ID-6", "monitor", "BenQ", BigDecimal.valueOf(200), 40, INPUT_OUTPUT_DEVICE, HDMI);
        Device seventh = new OuterDevice("ID-7", "Speakers", "JBC", BigDecimal.valueOf(100), 50, MULTIMEIDA, JACK_THREE_DOT_FIVE);
        Device eighth = new OuterDevice("ID-8", "Mouse", "A4Tech", BigDecimal.valueOf(30), 1, INPUT_OUTPUT_DEVICE, USB);
        Device ninth = new OuterDevice("ID-9", "Keyboard", "Razer", BigDecimal.valueOf(50), 2, INPUT_OUTPUT_DEVICE, USB);
        Device tenth = new OuterDevice("ID-10", "Headphones", "Plantronics", BigDecimal.valueOf(100), 5, MULTIMEIDA, JACK_THREE_DOT_FIVE);

        List<Device> devices = new ArrayList<>();
        devices.add(first);
        devices.add(second);
        devices.add(third);
        devices.add(fourth);
        devices.add(fifth);
        devices.add(sixth);
        devices.add(seventh);
        devices.add(eighth);
        devices.add(ninth);
        devices.add(tenth);
        return devices;
    }

    public static String getPartToFile() {
        return PART_TO_FILE;
    }

    public static String getPartToSchema() {
        return PART_TO_SCHEMA;
    }
}
