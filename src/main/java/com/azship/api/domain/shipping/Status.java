package com.azship.api.domain.shipping;

public enum Status {

    PREPARING("preparing"),
    READY("ready"),
    SENT("sent"),
    DELIVERED("delivered");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getStatus() {
        return value;
    }

}
