package com.azship.api.domain.shipping.resource.request;

import com.azship.api.domain.shipping.Status;

public record StatusUpdatingRequest(String id, Status status) {
}
