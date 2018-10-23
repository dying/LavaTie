package com.dabbotorg.lavatie.client.rest;

import com.dabbotorg.lavatie.client.services.CachedClientRepository;
import com.dabbotorg.lavatie.commons.rest.ResourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clients")
@Resource
public class ClientResource {
    @Autowired private CachedClientRepository clientRepository;
    @Autowired private ClientConverter converter;
    @Autowired private ResourceHelper helper;

    /**
     *
     * @param ids List of client IDs
     * @return Empty or ClientRepresentation[]
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientRepresentation> findAll(@RequestParam(value = "ids[]", required = false) List<Long> ids) {
        if(ids != null) {
            return helper.convertAll(converter, clientRepository.findAll(ids));
        }
        else {
            return helper.convertAll(converter, clientRepository.findAll());
        }
    }

    /**
     *
     * Creates a ClientRepresentation
     * @return Created ClientRepresentation
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientRepresentation add(@Valid final ClientRepresentation representation) {
        return helper.create(clientRepository, converter, representation);
    }
}
