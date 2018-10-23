package com.dabbotorg.lavatie.client.services;

import com.dabbotorg.lavatie.client.api.Client;
import com.dabbotorg.lavatie.client.api.ClientRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CachedClientRepository implements ClientRepository {

    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    @NonNull
    public Client findOneByPath(String path) throws IOException {
        return clients.stream().filter(c -> Objects.equals(c.path, path)).findFirst().orElseThrow(IOException::new);
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
    public List<Client> findAll() {
        return new ArrayList<>(clients); // making a copy simulates the rest, enforcing encapsulation
    }

    @Override
    @NonNull
    public List<Client> findAll(@NonNull List<Long> ids) {
        return clients.stream().filter(c -> ids.contains(c.id)).collect(Collectors.toList());
    }

    // TODO: remove lazy code, remove try/catch and make it actually good
    @Override
    public boolean delete(@Nullable long id) {
        try {
            return clients.remove(clients.stream().filter(c -> Objects.equals(c.id, id)).findFirst().orElseThrow(IOException::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // TODO: remove lazy code, remove try/catch and make it actually good
    @Override
    public Client update(@NonNull Client client) {
        try {
            return clients.stream().filter(c -> Objects.equals(c.id, client.id)).findFirst().orElseThrow(IOException::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    // TODO: remove lazy code, remove try/catch and make it actually good
    @Override
    public Client add(@NonNull Client client) {
        try {
            clients.add(client);
            return client;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return client;
    }
}
