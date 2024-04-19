package com.azship.api.domain.shipping;

public enum ShippingType {
    DEFAULT("default"),
    EXPRESS("express");

    private String name;

    ShippingType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
