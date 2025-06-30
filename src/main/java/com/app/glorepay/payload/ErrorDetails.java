package com.app.glorepay.payload;

import lombok.Getter;

import java.util.Date;

/*
    * This class is used to create a custom error response
      when an exception is thrown.
 */
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String description;

    public ErrorDetails(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
