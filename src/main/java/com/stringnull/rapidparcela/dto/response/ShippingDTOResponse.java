package com.stringnull.rapidparcela.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stringnull.rapidparcela.models.DeliveryPersonel;
import com.stringnull.rapidparcela.models.ShippingDetails;
import com.stringnull.rapidparcela.models.ShippingStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingDTOResponse {

    private long id;
    @NotNull @NotBlank
    private String referenceNumber;
    private LocalDateTime shippingDate;
    @NotNull
    private BigDecimal amount;
    private NestedCustomerDTO customer;
    private DeliveryPersonel deliveryPersonel;
    private ShippingDetails shippingDetails;
    private ShippingStatus shippingStatus;

}

@Data
class NestedCustomerDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String address;
    private String email;
    private String contact;
    private String username;
}
