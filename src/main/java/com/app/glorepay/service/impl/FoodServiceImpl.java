package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.Food;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.FoodDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.FoodRepository;
import com.app.glorepay.service.EmployeeService;
import com.app.glorepay.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a food service
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public FoodDto createFood(Long id, FoodDto foodDto) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee==null){
            throw new ResourceNotFoundException("Employee", "employeeId", id);
        }
        Food food = foodRepository.findByfoodId(foodDto.getFoodId());
        if (food != null) {
            throw new RuntimeException("Food with given id exists");
        }
        Food food1 = new Food();
        food1.setType(foodDto.getType());
        food1.setDate(foodDto.getDate());
        food1.setAmount(foodDto.getAmount());
        food1.setEmployee(employee);
        foodRepository.save(food1);

        FoodDto foodDto1 = new FoodDto();
        foodDto1.setFoodId(food1.getFoodId());
        foodDto1.setType(food1.getType());
        foodDto1.setDate(food1.getDate());
        foodDto1.setAmount(food1.getAmount());
        foodDto1.setEmployeeId(id);
        return foodDto1;
    }

    @Override
    public FoodDto getFoodById(Long id, Long foodId) {
        Employee employee = employeeRepository.findByemployeeId(id);
        if(employee == null){
            throw new ResourceNotFoundException("employee", "employeeId", id);
        }
        Food food = foodRepository.findByfoodId(foodId);
        if(food == null){
            throw new ResourceNotFoundException("food", "foodid", foodId);

        }
        if(!food.getEmployee().getEmployeeId().equals(id)){
            throw new RuntimeException("Employee not associated with food");
        }
        FoodDto foodDto = new FoodDto();
        foodDto.setFoodId(food.getFoodId());
        foodDto.setType(food.getType());
        foodDto.setDate(food.getDate());
        foodDto.setAmount(food.getAmount());
        foodDto.setEmployeeId(id);

        return foodDto;
    }
}
