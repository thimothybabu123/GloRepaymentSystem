package com.app.glorepay.payload;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * type should not be null or blank
      * date should not be null
      * amount should not be null and should be a positive number or zero
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long foodId;
    @NotBlank(message = "Food type should not be null or blank")
    private String type;
    @NotNull(message = "date should be in correct format")
    @PastOrPresent(message = "Date must be today or in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "amount should not be null or blank")
    @Positive(message = "amount should be a positive number")
    private Integer amount;
//    @NotNull
    private Long employeeId;
}
