package com.dabbotorg.lavatie.client.rest;

import com.dabbotorg.lavatie.client.api.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

public class ClientConverterTest {

    public ClientConverter converter = new ClientConverter();

    @Test
    public void convertTo_canConvertTo() {
        Client client = new Client();
        ClientRepresentation representation = new ClientRepresentation();

        client.setId(1);
        client.setPath("127.0.0.1:5000");

        representation = converter.convertTo(client, representation);
        assertEquals(representation.getId(), client.getId());
        assertEquals(representation.getPath(), client.getPath());
    }

    @Test
    public void convertFrom_canConvertFrom() {
        Client client = new Client();
        ClientRepresentation representation = new ClientRepresentation();

        representation.setId(1);
        representation.setPath("127.0.0.1:5000");

        client = converter.convertFrom(representation, client);
        assertEquals(representation.getId(), client.getId());
        assertEquals(representation.getPath(), client.getPath());
    }
}