package com.app.glorepay.controller;


import com.app.glorepay.payload.PublicTransportDto;
import com.app.glorepay.service.PublicTransportService;
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
public class PublicTransportController {

    @Autowired
    private PublicTransportService publicTransportService;
    // create public transport REST API
    @PostMapping("/{id}/publicTransport")
    public ResponseEntity<PublicTransportDto> addPublic(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                                        @RequestBody @Valid PublicTransportDto publicTransportDto)
            throws  RuntimeException{
        PublicTransportDto publicTransportDto1 = publicTransportService.createPublicTransport(id, publicTransportDto);
        return new ResponseEntity<>(publicTransportDto1, HttpStatus.OK);
    }

    // get public transport by EmpId and publicTransportId REST API

    @GetMapping("/{id}/publicTransport/{publicId}")
    public ResponseEntity<PublicTransportDto> getPublic(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                                        @PathVariable @NotNull(message = "public id can not be null") Long publicId) throws  RuntimeException{
        PublicTransportDto publicTransportDto1 = publicTransportService.getPublicTransportById(id, publicId);
        return new ResponseEntity<>(publicTransportDto1, HttpStatus.OK);
    }
}
