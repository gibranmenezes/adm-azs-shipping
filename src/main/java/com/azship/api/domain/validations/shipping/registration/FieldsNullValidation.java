package com.azship.api.domain.validations.shipping.registration;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class FieldsNullValidation implements CreateShippingValidator {
    @Override
    public void validate(ShippingRequest data)  {
        if(this.allFieldsAreNullOrBlank(data)) {
            throw new ValidationException(("A least one field is required"));
        }

    }
    private boolean allFieldsAreNullOrBlank(ShippingRequest request) {

        return request.postalCode() == null
                && request.packAmount() == null
                && request.weight() == null
                && request.volume() == null;
    }

}
