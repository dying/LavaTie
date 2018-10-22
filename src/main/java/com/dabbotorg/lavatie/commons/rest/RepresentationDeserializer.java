package com.dabbotorg.lavatie.commons.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RepresentationDeserializer extends JsonDeserializer<RepresentationId> {

    @Override
    public RepresentationId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);

        if(node.isNull()) {
            return null;
        }
        else if(node.isLong()) {
            return new RepresentationIdLong(node.longValue());
        }
        else if(node.isInt()) {
            return new RepresentationIdLong((long) (node.intValue()));
        }
        else if(node.isObject() && node.has("id") && node.get("id").isLong()) {
            return new RepresentationIdLong(node.get("id").longValue());
        }
        else if(node.isTextual() && !node.textValue().isEmpty()) {
            return new RepresentationIdLong(Long.parseLong(node.textValue()));
        }
        else {
            return null;
        }
    }
}
