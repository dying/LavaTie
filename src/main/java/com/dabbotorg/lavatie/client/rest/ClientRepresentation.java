package com.dabbotorg.lavatie.client.rest;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ClientRepresentation {
    private long id;
    private String path;
}
