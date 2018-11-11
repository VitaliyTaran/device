package com.epam.device.entity.component.inner;

import com.epam.device.entity.Device;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlRootElement
@XmlType(name = "inner-device")
@XmlSeeAlso(Device.class)
public class InnerDevice extends Device {
    @XmlElement(name = "with-cooler")
    private boolean withCooler;
    @XmlElement(name = "port")
    private InnerDevicePorts port;

    public InnerDevice() {
    }

    public InnerDevice(String id, String name, String firm, BigDecimal price, int powerConsumption, boolean withCooler, InnerDevicePorts port) {
        super(id, name, firm, price, powerConsumption);
        this.withCooler = withCooler;
        this.port = port;
    }

    public InnerDevice(Device computerPart) {
        super(computerPart);
    }

    public boolean isWithCooler() {
        return withCooler;
    }

    public void setWithCooler(boolean withCooler) {
        this.withCooler = withCooler;
    }

    public InnerDevicePorts getPort() {
        return port;
    }

    public void setPort(InnerDevicePorts port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InnerDevice)) return false;

        InnerDevice innerComponent = (InnerDevice) o;

        return (withCooler == innerComponent.withCooler
                && port == innerComponent.port);
    }

    @Override
    public String toString() {
        return super.toString() +
                "withCooler=" + withCooler +
                ", port=" + port +
                "}\n";
    }
}
