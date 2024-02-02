package com.stringnull.rapidparcela.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stringnull.rapidparcela.models.DeliveryPersonel;
import com.stringnull.rapidparcela.models.ShippingDetails;
import com.stringnull.rapidparcela.models.ShippingStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingDTORequest implements Serializable {
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
