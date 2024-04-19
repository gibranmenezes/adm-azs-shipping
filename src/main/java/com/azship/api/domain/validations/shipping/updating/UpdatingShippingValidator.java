package com.azship.api.domain.validations.shipping.updating;


import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;

public interface UpdatingShippingValidator {

    void validate(StatusUpdatingRequest request);
}
