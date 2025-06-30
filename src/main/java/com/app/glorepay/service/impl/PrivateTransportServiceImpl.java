package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.Food;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.PrivateTransportRepository;
import com.app.glorepay.service.PrivateTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a private transport service
@Service
public class PrivateTransportServiceImpl implements PrivateTransportService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PrivateTransportRepository privateTransportRepository;
    @Override
    public PrivateTransportDto createPrivateTransport(Long id, PrivateTransportDto privateTransportDto) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee == null){
            throw new ResourceNotFoundException("employee", "employeeId", id);
        }
        PrivateTransport privateTransport = new PrivateTransport();
        privateTransport.setType(privateTransportDto.getType());
        privateTransport.setDate(privateTransportDto.getDate());
        privateTransport.setMiles(privateTransportDto.getMiles());
        privateTransport.setAmount(privateTransportDto.getAmount());
        privateTransport.setEmployee(employee);
        privateTransportRepository.save(privateTransport);

        PrivateTransportDto privateTransportDto1 = new PrivateTransportDto();
        privateTransportDto1.setPrivateTransportId(privateTransport.getPrivateTransportId());
        privateTransportDto1.setType(privateTransport.getType());
        privateTransportDto1.setDate(privateTransport.getDate());
        privateTransportDto1.setMiles(privateTransport.getMiles());
        privateTransportDto1.setAmount(privateTransport.getAmount());
        privateTransportDto1.setEmployeeId(id);

        return privateTransportDto1;
    }

    @Override
    public PrivateTransportDto getPrivateTransportById(Long id, Long privateTransportId) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee == null){
            throw new ResourceNotFoundException("employee", "employeeId", id);
        }
        PrivateTransport privateTransport = privateTransportRepository.findByprivateTransportId(privateTransportId);
        if(privateTransport == null){
            throw new ResourceNotFoundException("private Transport", "privateTransportId", privateTransportId);

        }
        if(!privateTransport.getEmployee().getEmployeeId().equals(id)){
            throw new RuntimeException("Employee not associated with private transport");
        }
        PrivateTransportDto privateTransportDto = new PrivateTransportDto();
        privateTransportDto.setPrivateTransportId(privateTransport.getPrivateTransportId());
        privateTransportDto.setType(privateTransport.getType());
        privateTransportDto.setDate(privateTransport.getDate());
        privateTransportDto.setMiles(privateTransport.getMiles());
        privateTransportDto.setAmount(privateTransport.getAmount());
        privateTransportDto.setEmployeeId(id);
        return privateTransportDto;
    }
}
