package com.dabbotorg.lavatie.client.services;

import com.dabbotorg.lavatie.client.api.Client;
import com.dabbotorg.lavatie.client.api.ClientRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Cacheable
@Repository
public class CachedClientRepository implements ClientRepository {

    private List<Client> clients = new ArrayList<>();

    @Override
    @NonNull
    public Client findOneByPath(String path) throws NotFoundException {
        return clients.stream().filter(c -> Objects.equals(c.path, path)).findFirst().orElseThrow(NotFoundException::new);
    }

    @Override
    @NonNull
    public List<? extends Client> findAllByPath(String path, boolean startsWith) {
        return clients.stream().filter(c -> Objects.equals(c.path, path)).collect(Collectors.toList());
    }

    @Override
    @Nullable
    public Client findOrNull(long id) {
        return clients.stream().filter(c -> Objects.equals(c.id, id)).findFirst().orElse(null);
    }

    @Override
    @NonNull
    public List<? extends Client> findAll() {
        return new ArrayList<>(clients); // making a copy simulates the rest, enforcing encapsulation
    }

    @Override
    @NonNull
    public List<? extends Client> findAll(@NonNull List<Long> ids) {
        return clients.stream().filter(c -> ids.contains(c.id)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(@Nullable Client client) {
        return clients.remove(client);
    }

    @Override
    public boolean add(@NonNull Client client) {
        return clients.add(client);
    }
}
