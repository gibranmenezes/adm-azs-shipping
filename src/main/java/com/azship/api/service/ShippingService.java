package com.azship.api.service;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.request.ShippingUpdateRequest;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.domain.shipping.resource.response.ShippingUpdateResponse;
import com.azship.api.domain.shipping.resource.response.StatusUpdateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShippingService {

    ShippingResponse create(ShippingRequest request);

    ShippingResponse getShipping(String id);

    Page<ShippingResponse> getAllByUserId(String userId, Pageable pagination);

    StatusUpdateResponse updateStatus(StatusUpdatingRequest request);

    ShippingUpdateResponse updateShipping(ShippingUpdateRequest request);

    void removeShipping(String id);


}
