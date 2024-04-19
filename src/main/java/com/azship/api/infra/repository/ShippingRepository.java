package com.azship.api.infra.repository;

import com.azship.api.domain.shipping.Shipping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShippingRepository extends MongoRepository<Shipping, String> {

    Page<Shipping> findAllByUserId(String userId, Pageable pagination);

    Shipping findShippingById(String id);
}
