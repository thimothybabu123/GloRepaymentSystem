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
      * amount should not be null and should be a positive number
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicTransportDto {
    private Long publicTransportId;

    @NotBlank(message = "Type should not be null or blank")
    private String type;

    @NotNull(message = "date should not be null or blank")
    @PastOrPresent(message = "Date must be today or in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull(message = "amount should not be null or blank")
    @Positive(message = "amount should be positive")
    private Integer amount;
    private Long employeeId;
}
