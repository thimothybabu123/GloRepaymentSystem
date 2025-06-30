package com.app.glorepay.service;

import com.app.glorepay.payload.PublicTransportDto;

public interface PublicTransportService {
    // It is a service to create a public transport
    PublicTransportDto createPublicTransport(Long id, PublicTransportDto publicTransportDto);
    // It is a service to get a public transport by id
    PublicTransportDto getPublicTransportById(Long id,Long publicTransportId);
}
