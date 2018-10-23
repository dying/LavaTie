package com.dabbotorg.lavatie;

import com.dabbotorg.lavatie.client.services.NoClientsException;
import com.dabbotorg.lavatie.commons.rest.ExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoClientsException.class)
    public final ResponseEntity<String> handleNoClientsException(NoClientsException ex, WebRequest request) {
        Gson gson = new Gson(); // Gson because Jackson is WHACK
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(gson.toJson(response), HttpStatus.NOT_FOUND);
    }


}
