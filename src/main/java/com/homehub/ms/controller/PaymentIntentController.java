package com.homehub.ms.controller;

import com.homehub.ms.dto.CreateCustomerRequest;
import com.homehub.ms.dto.CreateCustomerResponseDTO;
import com.homehub.ms.dto.CreatePaymentIntentRequestDTO;
import com.homehub.ms.service.CreatePaymentIntentInterface;
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
@RequestMapping("/v1/paymentIntent")
@Slf4j
public class PaymentIntentController {

    @Autowired
    CreatePaymentIntentInterface createPaymentIntentService;


    @ApiOperation(value="Creates payment intent that tries to charge user with requested amount")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> createPaymentIntent(@RequestBody CreatePaymentIntentRequestDTO createPaymentIntentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createPaymentIntentService.createPaymentIntent(createPaymentIntentRequest));
    }
}
