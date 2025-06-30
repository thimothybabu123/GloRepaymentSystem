package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.entity.PublicTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.payload.PublicTransportDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.PublicTransportRepository;
import com.app.glorepay.service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a public transport service
@Service
public class PublicTransportServiceImpl implements PublicTransportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PublicTransportRepository publicTransportRepository;
    @Override
    public PublicTransportDto createPublicTransport(Long id, PublicTransportDto publicTransportDto) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee==null){
            throw new ResourceNotFoundException("Employee", "employeeId", id);
        }
        PublicTransport publicTransport = new PublicTransport();
        publicTransport.setType(publicTransportDto.getType());
        publicTransport.setDate(publicTransportDto.getDate());
        publicTransport.setAmount(publicTransportDto.getAmount());
        publicTransport.setEmployee(employee);
        publicTransportRepository.save(publicTransport);

        PublicTransportDto publicTransportDto1 = new PublicTransportDto();
        publicTransportDto1.setPublicTransportId(publicTransport.getPublicTransportId());
        publicTransportDto1.setType(publicTransport.getType());
        publicTransportDto1.setDate(publicTransportDto.getDate());
        publicTransportDto1.setAmount(publicTransportDto.getAmount());
        publicTransportDto1.setEmployeeId(id);

        return publicTransportDto1;
    }

    @Override
    public PublicTransportDto getPublicTransportById(Long id, Long publicTransportId) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee == null){
            throw new ResourceNotFoundException("employee", "employeeId", id);
        }
        PublicTransport publicTransport = publicTransportRepository.findBypublicTransportId(publicTransportId);
        if(publicTransport == null){
            throw new ResourceNotFoundException("public Transport", "publicTransportId", publicTransportId);

        }
        if(!publicTransport.getEmployee().getEmployeeId().equals(id)){
            throw new RuntimeException("Employee not associated with private transport");
        }
        PublicTransportDto publicTransportDto = new PublicTransportDto();
        publicTransportDto.setPublicTransportId(publicTransport.getPublicTransportId());
        publicTransportDto.setType(publicTransport.getType());
        publicTransportDto.setDate(publicTransport.getDate());
        publicTransportDto.setAmount(publicTransport.getAmount());
        publicTransportDto.setEmployeeId(id);
        return publicTransportDto;
    }
}
