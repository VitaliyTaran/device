package com.epam.device.entity.component.outer;

import com.epam.device.entity.Device;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlRootElement
@XmlType(name = "outer-device")
@XmlSeeAlso(Device.class)
public class OuterDevice extends Device {
    @XmlElement(name = "group")
    private GroupOfOuterDevicePart group;
    @XmlElement(name = "port")
    private OuterDevicePorts port;

    public OuterDevice() {
    }

    public OuterDevice(String id, String name, String firm, BigDecimal price, int powerConsumption, GroupOfOuterDevicePart group, OuterDevicePorts port) {
        super(id, name, firm, price, powerConsumption);
        this.group = group;
        this.port = port;
    }

    public OuterDevice(Device computerPart) {
        super(computerPart);
    }

    public GroupOfOuterDevicePart getGroup() {
        return group;
    }

    public void setGroup(GroupOfOuterDevicePart group) {
        this.group = group;
    }

    public OuterDevicePorts getPort() {
        return port;
    }

    public void setPort(OuterDevicePorts port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OuterDevice component = (OuterDevice) o;

        return (port == component.port && group == component.group);
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "group=" + group +
                ", port=" + port +
                "}\n";
    }
}
