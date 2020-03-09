package com.homehub.ms.controller;

import com.homehub.ms.dto.CreateCustomerRequest;
import com.homehub.ms.dto.CreateCustomerResponseDTO;
import com.homehub.ms.dto.CreatePaymentMethodRequestDTO;
import com.homehub.ms.dto.CreatePaymentMethodResponseDTO;
import com.homehub.ms.service.CreatePaymentMethodInterface;
import com.homehub.ms.service.CustomerInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
@RequestMapping("/v1/paymentMethod")
@Slf4j
public class PaymentMethodController {

    @Autowired
    CreatePaymentMethodInterface createPaymentMethod;

    @ApiOperation(value="Creates payment method id by customer vendor ID ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<CreatePaymentMethodResponseDTO> createUser(@RequestBody CreatePaymentMethodRequestDTO createPaymentMethodRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createPaymentMethod.createPaymentMethod(createPaymentMethodRequest));
    }
}
