package com.azship.api.domain.shipping.resource.request;

import com.azship.api.domain.shipping.ShippingType;
import jakarta.validation.constraints.NotNull;

public record ShippingRequest(@NotNull String userID, String postalCode,
                              Double weight, Double volume, Integer packAmount,  @NotNull ShippingType type) {
}
