package com.app.glorepay.util;


import com.app.glorepay.GloRepayApplication;
import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.Food;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.entity.PublicTransport;
import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.payload.FoodDto;
import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.payload.PublicTransportDto;

// This class is used to map the entity to the dto and vice versa

public class Mapper {
    // map the public transport entity to public transport dto
    public static PublicTransportDto mapToPublicTransportDto(PublicTransport publicTransport) {
        return GloRepayApplication.modelMapper().map(publicTransport, PublicTransportDto.class);

    }

    // map the public transport dto to public transport entity
    public static PublicTransport mapToPublicTransportEntity(PublicTransportDto publicTransportDto) {
        return GloRepayApplication.modelMapper().map(publicTransportDto, PublicTransport.class);
    }

    // map the employee entity to employee dto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return GloRepayApplication.modelMapper().map(employee, EmployeeDto.class);
    }

    // map the employee dto to employee entity
    public static Employee mapToEmployeeEntity(EmployeeDto employeeDto) {
        return GloRepayApplication.modelMapper().map(employeeDto, Employee.class);
    }

    // map the private transport entity to private transport dto
    public static PrivateTransportDto mapToPrivateTransportDto(PrivateTransport privateTransport) {
        return GloRepayApplication.modelMapper().map(privateTransport, PrivateTransportDto.class);
    }

    // map the private transport dto to private transport entity
    public static PrivateTransport mapToPrivateTransportEntity(PrivateTransportDto privateTransportDto) {
        return GloRepayApplication.modelMapper().map(privateTransportDto, PrivateTransport.class);
    }

    // map the food entity to food dto
    public static FoodDto mapToFoodDto(Food food) {
        return GloRepayApplication.modelMapper().map(food, FoodDto.class);
    }

    // map the food dto to food entity
    public static Food mapToFoodEntity(FoodDto foodDto) {
        return GloRepayApplication.modelMapper().map(foodDto, Food.class);
    }

}
