package com.dabbotorg.lavatie.commons.rest;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ResourceHelper {
    public <E, R> List<R> convertAll(Converter<E, R> converter, Iterable<? extends E> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(e -> getRepresentation(converter, e))
                .collect(Collectors.toList());
    }

    public <E, R> R getRepresentation(Converter<? super E, R> converter, E entity) {
        return converter.convertTo(entity, null);
    }
}
