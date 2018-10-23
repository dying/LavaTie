package com.dabbotorg.lavatie.commons.rest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ExceptionResponse {
    @Getter @Setter
    private String message;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private HttpStatus statusCode;

    public ExceptionResponse(String message, Date date, HttpStatus statusCode) {
        super();
        this.message = message;
        this.date = date;
        this.statusCode = statusCode;
    }

}