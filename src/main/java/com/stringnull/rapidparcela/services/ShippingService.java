package com.stringnull.rapidparcela.services;

import com.stringnull.rapidparcela.dto.request.CustomerDTORequest;
import com.stringnull.rapidparcela.dto.request.ShippingDTORequest;
import com.stringnull.rapidparcela.dto.response.CustomerDTOResponse;
import com.stringnull.rapidparcela.dto.response.ShippingDTOResponse;
import com.stringnull.rapidparcela.models.Customer;
import com.stringnull.rapidparcela.models.Shipping;
import com.stringnull.rapidparcela.repositories.ShippingRepository;
import com.stringnull.rapidparcela.validation.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ApiResponse<?> getAllShipping() {
        try {
            List<ShippingDTOResponse> list = shippingRepository.findAll().stream().map(e -> modelMapper.map(e, ShippingDTOResponse.class)).toList();
            return new ApiResponse<>().success(list);
        } catch (Exception e) {
            return new ApiResponse<>().error("Error getting shipping list.");
        }
    }

    public ApiResponse<?> saveShipping(ShippingDTORequest shipping) {
        try {
            Shipping saveShipping = shippingRepository.save(modelMapper.map(shipping, Shipping.class));
            return new ApiResponse<>().success(modelMapper.map(saveShipping, ShippingDTOResponse.class));
        } catch (DataAccessException dae) {
            return new ApiResponse<>().error(dae.getMostSpecificCause().getMessage());
        }
    }

    public ApiResponse<?> getShippingById(long i) {
        Shipping shipping = shippingRepository.findById(i).orElse(null);
        if (shipping != null)
            return new ApiResponse<>().success(modelMapper.map(shipping, ShippingDTOResponse.class));
        else
            return new ApiResponse<>().error("Shipping Not found id: " + i);
    }

    public ApiResponse<?> deleteShippingById(long id) {
        Shipping shipping = shippingRepository.findById(id).orElse(null);

        if (shipping != null) {
            //does this cascade?
            shippingRepository.delete(shipping);
            return new ApiResponse<>().success(modelMapper.map(shipping, ShippingDTOResponse.class));
        }

        return new ApiResponse<>().error("Deleting shipping unsuccessful");
    }
    public ApiResponse<?> updateShipping(long id, ShippingDTORequest updatedShipping) {
        try {
            Shipping existingShipping = shippingRepository.findById(id).orElse(null);

            if (existingShipping != null) {

                existingShipping.setReferenceNumber(updatedShipping.getReferenceNumber());
                existingShipping.setAmount(updatedShipping.getAmount());

                var merged = shippingRepository.save(existingShipping);
                return new ApiResponse<>().success(modelMapper.map(merged, ShippingDTOResponse.class));
            } else {
                return new ApiResponse<>().error("Shipping did not found");
            }
        } catch (Exception e) {
            return new ApiResponse<>().error("Shipping did not update: " + e.getMessage());
        }
    }


}
