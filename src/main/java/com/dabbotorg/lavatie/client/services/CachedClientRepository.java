package com.dabbotorg.lavatie.client.services;

import com.dabbotorg.lavatie.client.api.Client;
import com.dabbotorg.lavatie.client.api.ClientRepository;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Cacheable
@Repository
public class CachedClientRepository implements ClientRepository {

    private List<Client> clients = new ArrayList<>();

    @Override
    public Client findOneByPath(String path) {
        return (Client) Optional.of(clients.stream().filter(c -> c.path.equals(path))).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<? extends Client> findAllByPath(String path, boolean startsWith) {
        return Optional.of(clients.stream().filter(c -> c.path == path).collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    @Override
    public Client findOrNull(long id) {
        return (Client) Optional.of(clients.stream().filter(c -> c.id == id)).orElse(null);
    }

    @Override
    public List<? extends Client> findAll() {
        return clients;
    }

    @Override
    public List<? extends Client> findAll(List<Long> ids) {
        return Optional.of(clients.stream().filter(c -> ids.contains(c.id)).collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    @Override
    public boolean delete(Client client) {
        return clients.remove(client);
    }

    @Override
    public boolean add(Client client) {
        return clients.add(client);
    }
}
