package com.azship.api.domain.shipping.resource.response;

import com.azship.api.domain.shipping.Shipping;
import com.azship.api.domain.shipping.Status;

import java.time.LocalDate;

public record StatusUpdateResponse(String id, Status status, LocalDate sendDate, LocalDate deliveryDate) {
    public StatusUpdateResponse(Shipping shipping){
        this(shipping.getId(), shipping.getStatus(), shipping.getSendDate(), shipping.getDeliveryDate());
    }
}
