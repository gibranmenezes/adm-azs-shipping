package com.azship.api.domain.validations.shipping.registration;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;

public interface CreateShippingValidator {

    void validate(ShippingRequest data) ;


}
