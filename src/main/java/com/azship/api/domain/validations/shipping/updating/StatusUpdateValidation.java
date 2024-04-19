package com.azship.api.domain.validations.shipping.updating;

import com.azship.api.domain.shipping.Status;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.infra.exception.ValidationException;
import com.azship.api.infra.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.azship.api.domain.shipping.Status.*;

@Component
@RequiredArgsConstructor
public class StatusUpdateValidation implements UpdatingShippingValidator{
    private final ShippingRepository repository;

    @Override
    public void validate(StatusUpdatingRequest request) {
        var shipping = repository.findShippingById(request.id());
        var currentStatus = shipping.getStatus();
        var newStatus = request.status();
        switch (newStatus) {
            case READY -> {
                if (currentStatus != Status.PREPARING) {
                    throw new ValidationException("Status cannot be updated to READY unless current status is PREPARING");
                }
            }
            case SENT -> {
                if (currentStatus != READY) {
                    throw new ValidationException("Status cannot be updated to SENT unless current status is READY");
                }
            }
            case DELIVERED -> {
                if (currentStatus != SENT) {
                    throw new ValidationException("Status cannot be updated to DELIVERED unless current status is SENT");
                }
            }
            default -> {
            }

        }
    }
}
