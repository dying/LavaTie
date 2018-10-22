package com.dabbotorg.lavatie.client.rest;

import com.dabbotorg.lavatie.client.services.CachedClientRepository;
import com.dabbotorg.lavatie.commons.rest.ResourceHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
@Resource
public class ClientResource {
    @Autowired private CachedClientRepository clientRepository;
    @Autowired private ClientConverter converter;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private ResourceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findAll(@QueryParam("ids[]") List<Long> ids) {
        if(ids != null) {
            return helper.convertAll(converter, clientRepository.findAll(ids));
        }
        else {
            return helper.convertAll(converter, clientRepository.findAll());
        }
    }
}
