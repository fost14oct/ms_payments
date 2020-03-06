package com.homehub.ms.controller;

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

    @ApiOperation(value="Gets OCR list in pageable form")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OPERATION SUCCESSFUL"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
    })
    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE,consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> createUser(@RequestBody String externalID) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerservice.createClientWithExternalID(externalID));
    }
}
