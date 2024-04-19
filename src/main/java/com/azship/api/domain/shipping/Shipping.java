package com.azship.api.domain.shipping;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.request.ShippingUpdateRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection  = "shippings")
public class Shipping {

    @Id
    private String id;
    private String code;
    private String userId;
    private String postalCode;
    private Double weight;
    private Double volume;
    private Status status;
    private ShippingType type;
    private LocalDate sendDate;
    private LocalDate deliveryDate;
    private Integer packAmount;

    public Shipping(ShippingRequest data){
        this.status = Status.PREPARING;
        this.type = data.type();
        this.postalCode = data.postalCode();
        this.volume = data.volume();
        this.weight = data.weight();
    }

    public void updateProperties(ShippingUpdateRequest data){
        if (data.postalCode() != null){
            this.postalCode = data.postalCode();
        }
        if (data.volume() != null){
            this.volume = data.volume();
        }
        if (data.weight() != null){
            this.weight = data.weight();
        }
        if (data.packAmount() != null){
            this.packAmount = data.packAmount();
        }

    }

    public void generateCode() {
        this.code = UUID.randomUUID().toString();
    }




}
