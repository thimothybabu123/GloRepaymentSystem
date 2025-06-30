package com.app.glorepay.controller;


import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.payload.ResponseDto;
import com.app.glorepay.service.EmployeeService;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    // Create a new employee REST API
    @PostMapping()
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) throws RuntimeException{
        ResponseDto responseDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


    // get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable @NotNull(message = "id can not be null") Long id) throws RuntimeException{
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

}
