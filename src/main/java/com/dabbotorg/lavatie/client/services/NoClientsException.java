package com.dabbotorg.lavatie.client.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoClientsException extends RuntimeException {
    public NoClientsException() { super("There are no connected clients"); }
    public NoClientsException(String message) { super(message); }
}
