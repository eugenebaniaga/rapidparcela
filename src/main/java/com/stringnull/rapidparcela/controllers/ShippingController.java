package com.stringnull.rapidparcela.controllers;

import com.stringnull.rapidparcela.dto.request.ShippingDTORequest;
import com.stringnull.rapidparcela.services.ShippingService;
import com.stringnull.rapidparcela.validation.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping(path="/list")
    public ResponseEntity<ApiResponse<?>> getAllShipping() {
        return ResponseEntity.ok(shippingService.getAllShipping());
    }

    @PostMapping(path="/add")
    public ResponseEntity<ApiResponse<?>> createShipping(@Valid @RequestBody ShippingDTORequest shipping) {
        ApiResponse<?> resp = new ApiResponse<>().error("something happens...");
        resp = shippingService.saveShipping(shipping);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<ApiResponse<?>> deleteShippingById(@PathVariable long id) {
        return ResponseEntity.ok(shippingService.deleteShippingById(id));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ApiResponse<?>> getShippingById(@PathVariable long id) {
        return ResponseEntity.ok(shippingService.getShippingById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<?>> updateShipping(@PathVariable long id, @Valid @RequestBody ShippingDTORequest shippingDTORequest) {
        return ResponseEntity.ok(shippingService.updateShipping(id, shippingDTORequest));
    }
}
