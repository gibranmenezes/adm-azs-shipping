package com.azship.api.domain.shipping.resource.response;

import com.azship.api.domain.shipping.Shipping;
import com.azship.api.domain.shipping.ShippingType;
import com.azship.api.domain.shipping.Status;

import java.time.LocalDate;

public record ShippingUpdateResponse(String code, Status status, Double weight, Double volume
        , Integer packAmount, LocalDate deliveryDate, ShippingType type) {
    public ShippingUpdateResponse(Shipping shipping){
        this(shipping.getCode(), shipping.getStatus(), shipping.getWeight(), shipping.getVolume(),
                shipping.getPackAmount(), shipping.getDeliveryDate(), shipping.getType());
    }
}
