package com.epam.device.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "device")
public class Device {

    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;
    @XmlAttribute(name = "name" ,required = true)
    private String name;
    @XmlElement(name = "firm")
    private String firm;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "power-consumption")
    private int powerConsumption;

    public Device() {
    }

    public Device(String id, String name, String firm, BigDecimal price, int powerConsumption) {
        this.id = id;
        this.name = name;
        this.firm = firm;
        this.price = price;
        this.powerConsumption = powerConsumption;
    }

    public Device(Device computerPart) {
        this.id = computerPart.id;
        this.name = computerPart.name;
        this.firm = computerPart.firm;
        this.price = computerPart.price;
        this.powerConsumption = computerPart.powerConsumption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firm='" + firm + '\'' +
                ", price=" + price +
                ", powerConsumption=" + powerConsumption +" ,";
    }
}

