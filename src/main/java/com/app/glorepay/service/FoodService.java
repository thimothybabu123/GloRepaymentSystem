package com.app.glorepay.service;

import com.app.glorepay.payload.FoodDto;

public interface FoodService {
    // It is a service to create a food
    FoodDto createFood(Long id, FoodDto foodDto);
    // It is a service to get a food by id
    FoodDto getFoodById(Long id, Long foodId);
}
