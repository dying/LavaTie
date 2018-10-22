package com.dabbotorg.lavatie.commons.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RepresentationSerializer extends JsonSerializer<RepresentationId> {

    @Override
    public void serialize(RepresentationId id, JsonGenerator generator, SerializerProvider provider) throws IOException {
        if(id == null) {
            generator.writeNull();
        }
        else if(id instanceof RepresentationIdLong) {
            generator.writeNumber(id.getId());
        }
        else if(id instanceof RepresentationIdObject) {
            generator.writeStartObject();
            generator.writeStringField("name", ((RepresentationIdObject) id).getName());
            generator.writeNumberField("id", id.getId());
            generator.writeEndObject();
        }
    }
}
