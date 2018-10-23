package com.dabbotorg.lavatie.commons.rest;

import com.dabbotorg.lavatie.commons.rest.Converter;
import com.dabbotorg.lavatie.commons.data.Identifiable;
import com.dabbotorg.lavatie.commons.data.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
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

    public <E, R> R find(Converter<E, R> converter, E entity) {
        if (entity == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);

        return getRepresentation(converter, entity);
    }

    public <E extends Identifiable, R> R find(Repository<E> repository, Converter<? super E, R> converter, long id) {
        E entity = repository.findOrNull(id);
        if (entity == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);

        return getRepresentation(converter, entity);
    }

    public <E extends Identifiable, R> R find(Repository<? extends E> repository, Converter<? super E, R> converter, long id, R defaultRepresentation) {
        E entity = repository.findOrNull(id);
        if (entity == null) return defaultRepresentation;

        return getRepresentation(converter, entity);
    }

    public <E extends Identifiable, R> R create(Repository<E> repository, Converter<E, R> converter, R representation) {
        return getRepresentation(converter, repository.add(getEntity(converter, null, representation)));
    }

    public <E extends Identifiable, R> R update(Repository<E> repository, Converter<E, R> converter, long id, R representation) {
        E entity = repository.findOrNull(id);
        if (entity == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);

        E updatedEntity = getEntity(converter, entity, representation);
        entity.setId(id);
        return converter.convertTo(repository.update(entity), null);
    }

    public <E extends Identifiable> boolean delete(Repository<E> repository, long id) {
        return repository.delete(id);
    }

    public <E, R> R getRepresentation(Converter<? super E, R> converter, E entity) {
        return converter.convertTo(entity, null);
    }

    public <E, R> E getEntity(Converter<E, R> converter, E entity, R representation) {
        return converter.convertFrom(representation, entity);
    }

}
