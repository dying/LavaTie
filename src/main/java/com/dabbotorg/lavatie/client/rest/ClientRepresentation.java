package com.dabbotorg.lavatie.client.rest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode
@JsonTypeName("Client")
@JsonTypeInfo(property = "_type", include = JsonTypeInfo.As.PROPERTY, use = JsonTypeInfo.Id.NAME)
public class ClientRepresentation {
    private long id;
    private String path;
}
