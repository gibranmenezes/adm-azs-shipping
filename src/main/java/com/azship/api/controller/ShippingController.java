package com.azship.api.controller;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.request.ShippingUpdateRequest;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.domain.shipping.resource.response.ShippingUpdateResponse;
import com.azship.api.domain.shipping.resource.response.StatusUpdateResponse;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.service.imp.ShippingServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("shippings")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingServiceImp serviceImp;
    private final ShippingRepository shippingRepository;

    @PostMapping()
    public ResponseEntity<ShippingResponse> create(@RequestBody ShippingRequest request){
            return ResponseEntity.ok(serviceImp.create(request));
    }

    @GetMapping()
    public ResponseEntity<ShippingResponse> getShipping(@RequestBody String id) {
        return ResponseEntity.ok(serviceImp.getShipping(id));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Page<ShippingResponse>> getAll(@PathVariable String userId
            , @PageableDefault(size = 10, sort = {"id"}) Pageable pagination) {
        return ResponseEntity.ok(serviceImp.getAllByUserId(userId, pagination));
    }
    @PutMapping("/status")
    public ResponseEntity<StatusUpdateResponse> updateStatus(@RequestBody StatusUpdatingRequest request){
        return ResponseEntity.ok(serviceImp.updateStatus(request));
    }

    @PutMapping("/update")
    public ResponseEntity<ShippingUpdateResponse> updateShipping(@RequestBody ShippingUpdateRequest request){
        return ResponseEntity.ok(serviceImp.updateShipping(request));
    }


    @DeleteMapping()
    public void deleteShipping(@RequestBody String id){
        serviceImp.removeShipping(id);
    }

}
