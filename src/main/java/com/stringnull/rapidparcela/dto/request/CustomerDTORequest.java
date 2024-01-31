package com.stringnull.rapidparcela.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTORequest implements Serializable {

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

    @NotNull @NotBlank
    public String password;

    private List<ShippingDTORequest> shippings;

}