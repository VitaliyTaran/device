package com.epam.device.entity;

public enum XMLEnum {
    DEVICES("devices"),
    DEVICE("device"),
    ID("id"),
    INNERDEVICE("inner-device"),
    OUTERDEVICE("outer-device"),
    NAME("name"),
    FIRM("firm"),
    PRICE("price"),
    POWERCONSUMPTION("power-consumption"),
    ISWITHCOOLER("with-cooler"),
    GROUP("group"),
    PORT("port");
    private String value;

    XMLEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}