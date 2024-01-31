package com.stringnull.rapidparcela.dto.request;

import com.stringnull.rapidparcela.models.DeliveryPersonel;
import com.stringnull.rapidparcela.models.ShippingDetails;
import com.stringnull.rapidparcela.models.ShippingStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShippingDTORequest {
    private long id;
    @NotNull @NotBlank
    private String referenceNumber;
    private LocalDateTime shippingDate;
    @NotNull
    private BigDecimal amount;
    private CustomerDTORequest customer;
    private DeliveryPersonel deliveryPersonel;
    private ShippingDetails shippingDetails;
    private ShippingStatus shippingStatus;
}
