package com.dabbotorg.lavatie.client.rest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Data @EqualsAndHashCode
@Component
public class ClientRepresentation {
    private long id;
    private String path;
}
