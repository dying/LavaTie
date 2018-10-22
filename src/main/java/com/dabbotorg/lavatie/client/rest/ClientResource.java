package com.dabbotorg.lavatie.client.rest;

import com.dabbotorg.lavatie.client.services.CachedClientRepository;
import com.dabbotorg.lavatie.commons.rest.ResourceHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Slf4j
@RestController
@RequestMapping("clients")
public class ClientResource {
    @Autowired private CachedClientRepository clientRepository;
    @Autowired private ClientConverter converter;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private ResourceHelper helper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientRepresentation> findAll(@RequestParam("ids[]") List<Long> ids) {
        if(ids != null) {
            return helper.convertAll(converter, clientRepository.findAll(ids));
        }
        else {
            return helper.convertAll(converter, clientRepository.findAll());
        }
    }
}
