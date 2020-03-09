package com.homehub.ms.controller;

import com.homehub.ms.dto.CreateCustomerRequest;
import com.homehub.ms.dto.CreateCustomerResponseDTO;
import com.homehub.ms.service.CustomerInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerInterface customerservice;

    @ApiOperation(value="Creates customer o retrieves if it is already mapped in pg db")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
    })
    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE,consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<CreateCustomerResponseDTO> createUser(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerservice.createClientWithExternalID(createCustomerRequest.getExternalID()));
    }
}
