package com.app.glorepay.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * type should not be null or blank
      * date should not be null
      * miles should not be null and should be a positive number
      * amount should not be null and should be a positive number
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateTransportDto {
    private Long privateTransportId;
    @NotBlank(message = "Type can not be null or blank")
    private String type;

    @NotNull(message = "Date should be in correct format")
    @PastOrPresent(message = "Date must be today or in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull(message = "Miles should not be null or blank")
    @Positive(message = "miles should be positive value")
    private Integer miles;

    @NotNull(message = "Amount should not be null or blank")
    @Positive(message = "amount should be positive")
    private Integer amount;
    private Long employeeId;
}
