package com.app.glorepay.controller;


import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.service.PrivateTransportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Validated
public class PrivateTransportController {

    @Autowired
    private PrivateTransportService privateTransportService;
    // create private transport REST API
    @PostMapping("/{id}/privateTransport")
    public ResponseEntity<PrivateTransportDto> addTransport(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                                            @RequestBody @Valid PrivateTransportDto privateTransportDto)
            throws  RuntimeException{
        PrivateTransportDto privateTransportDto1 = privateTransportService.createPrivateTransport(id, privateTransportDto);
        return new ResponseEntity<>(privateTransportDto1, HttpStatus.OK);
    }

    // get private transport by EmpId and privateTransportId REST API
    @GetMapping("/{id}/privateTransport/{privateTransportId}")
    public  ResponseEntity<PrivateTransportDto> getPrivate(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                                           @PathVariable @NotNull(message = "private transport Id can not be null") Long privateTransportId)
            throws RuntimeException{
        PrivateTransportDto privateTransportDto = privateTransportService.getPrivateTransportById(id, privateTransportId);
        return  new ResponseEntity<>(privateTransportDto, HttpStatus.OK);
    }

}
