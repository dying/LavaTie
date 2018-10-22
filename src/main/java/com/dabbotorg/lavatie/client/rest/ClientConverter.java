package com.dabbotorg.lavatie.client.rest;

import com.dabbotorg.lavatie.client.api.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements BaseClientConverter {

    @Override
    public ClientRepresentation convertTo(Client e, ClientRepresentation r) {
        if(e == null) return null;
        if(r == null) r = new ClientRepresentation();

        r.setId(e.getId());
        r.setPath(e.getPath());

        return r;
    }

    @Override
    public Client convertFrom(ClientRepresentation r, Client e) {
        if(r == null) return null;
        if(e == null) e = new Client();
        e.setId(r.getId());
        e.setPath(r.getPath());
        return e;
    }

}
