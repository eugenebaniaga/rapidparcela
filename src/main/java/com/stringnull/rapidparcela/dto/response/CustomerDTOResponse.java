package com.stringnull.rapidparcela.dto.response;

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
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTOResponse implements Serializable {

    private long id;

    @NotNull @NotBlank
    private String firstname;

    @NotNull @NotBlank
    private String lastname;
    private String middlename;

    @NotNull @NotBlank
    private String address;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String contact;

    @NotNull @NotBlank
    private String username;

    private List<NestedShipping> shippings;
}
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class NestedShipping {
    private long id;
    private String referenceNumber;
    private LocalDateTime shippingDate;
    private BigDecimal amount;
    private DeliveryPersonel deliveryPersonel;
    private ShippingDetails shippingDetails;
    private ShippingStatus shippingStatus;
}