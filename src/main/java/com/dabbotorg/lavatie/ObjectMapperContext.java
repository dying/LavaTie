package com.dabbotorg.lavatie;

import com.dabbotorg.lavatie.commons.rest.RepresentationDeserializer;
import com.dabbotorg.lavatie.commons.rest.RepresentationId;
import com.dabbotorg.lavatie.commons.rest.RepresentationSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContext implements ContextResolver<ObjectMapper> {
    private final ObjectMapper objectMapper;

    public ObjectMapperContext() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(RepresentationId.class, new RepresentationSerializer());
        module.addDeserializer(RepresentationId.class, new RepresentationDeserializer());
        objectMapper.registerModule(module);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
