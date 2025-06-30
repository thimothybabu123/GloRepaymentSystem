package com.app.glorepay.service;

import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.payload.PublicTransportDto;

public interface PrivateTransportService {
    // It is a service to create a private transport
    PrivateTransportDto createPrivateTransport(Long id, PrivateTransportDto privateTransportDto);
    // It is a service to get a private transport by id
    PrivateTransportDto getPrivateTransportById(Long id, Long privateTransportId);
}
