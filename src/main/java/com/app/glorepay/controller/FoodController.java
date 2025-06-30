package com.app.glorepay.controller;


import com.app.glorepay.payload.FoodDto;
import com.app.glorepay.service.FoodService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Validated
public class FoodController {

    @Autowired
    private FoodService foodService;

    // create food REST API
    @PostMapping("/{id}/food")
    public ResponseEntity<FoodDto> addFood(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                           @RequestBody @Valid FoodDto foodDto)
            throws RuntimeException{
        FoodDto foodDto1 = foodService.createFood(id, foodDto);
        return new ResponseEntity<>(foodDto1, HttpStatus.OK);
    }

    // get food by empId and foodId REST API
    @GetMapping("/{id}/food/{foodId}")
    public ResponseEntity<FoodDto> getFood(@PathVariable @NotNull(message = "Id can not be null") Long id,
                                           @PathVariable @NotNull(message = "food id can not be null"
    ) Long foodId) throws RuntimeException{
        FoodDto foodDto = foodService.getFoodById(id, foodId);
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

}
