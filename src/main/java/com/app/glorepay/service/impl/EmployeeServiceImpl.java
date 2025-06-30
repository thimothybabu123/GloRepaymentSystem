package com.app.glorepay.service.impl;


import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.Food;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.entity.PublicTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.*;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// make this into a employee service
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findByemployeeId(employeeDto.getEmployeeId());
        if (employee != null) {
            throw new RuntimeException("Employee already exists");
        }
       Employee employee1 = new Employee();
        employee1.setName(employeeDto.getName());
        employee1.setEmail(employeeDto.getEmail());
        employeeRepository.save(employee1);

        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setEmployeeId(employee1.getEmployeeId());
        employeeDto1.setName(employee1.getName());
        employeeDto1.setEmail(employee1.getEmail());
//        employee1.getMaxLimit();
        return new ResponseDto("Created");
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee==null){
            throw  new ResourceNotFoundException("employee", "employeeId", id);
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());

        List<PublicTransportDto> publicTransportDtoList = new ArrayList<>();
        for(PublicTransport publicTransport : employee.getPublicTransport()){
            PublicTransportDto publicTransportDto = new PublicTransportDto();
            publicTransportDto.setPublicTransportId(publicTransport.getPublicTransportId());
            publicTransportDto.setType(publicTransport.getType());
            publicTransportDto.setDate(publicTransport.getDate());
            publicTransportDto.setAmount(publicTransport.getAmount());
            publicTransportDtoList.add(publicTransportDto);

        }
        employeeDto.setPublicTransportDtoList(publicTransportDtoList);

        List<PrivateTransportDto> privateTransportDtoList = new ArrayList<>();
        for(PrivateTransport privateTransport : employee.getPrivateTransport()){
            PrivateTransportDto privateTransportDto = new PrivateTransportDto();
            privateTransportDto.setPrivateTransportId(privateTransport.getPrivateTransportId());
            privateTransportDto.setType(privateTransport.getType());
            privateTransportDto.setDate(privateTransport.getDate());
            privateTransportDto.setMiles(privateTransport.getMiles());
            privateTransportDto.setAmount(privateTransport.getAmount());
            privateTransportDto.setEmployeeId(id);
            privateTransportDtoList.add(privateTransportDto);

        }
        employeeDto.setPrivateTransportDtoList(privateTransportDtoList);

        List<FoodDto> foodDtoList = new ArrayList<>();
        for(Food food : employee.getFood()){
            FoodDto foodDto = new FoodDto();
            foodDto.setFoodId(food.getFoodId());
            foodDto.setType(food.getType());
            foodDto.setDate(food.getDate());
            foodDto.setAmount(food.getAmount());
            foodDto.setEmployeeId(id);
            foodDtoList.add(foodDto);

        }

        employeeDto.setFoodDtoList(foodDtoList);
        return employeeDto;
    }
}
