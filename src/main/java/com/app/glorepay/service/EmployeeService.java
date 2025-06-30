package com.app.glorepay.service;


import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.payload.ResponseDto;

public interface EmployeeService {
    // It is a service to create an employee
    ResponseDto createEmployee(EmployeeDto employeeDto);
    // It is a service to get an employee by id
    EmployeeDto getEmployeeById(Long id);
}
