package com.app.glorepay.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * employee name should not be null and should have a minimum of 3 characters
      * employee email should not be null or blank and should be a valid email
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    @NotBlank(message = "Employee name should not be blank")
    @NotNull(message = "Employee name can not be null")
    @Size(min = 3, message = "Employee name should be minimum 3 characters")
    private String name;
    @Email(message = "email should be in correct format")
    @NotBlank(message = "Email should not be null or blank")
    private String email;
    private final Integer maxLimit = 5000;
    private List<PublicTransportDto> publicTransportDtoList;
    private List<PrivateTransportDto> privateTransportDtoList;
    private List<FoodDto> foodDtoList;
}
