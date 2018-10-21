package com.dabbotorg.lavatie.client.api;

import com.dabbotorg.lavatie.commons.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client> {
    Client findOneByPath(String path);
    List<? extends Client> findAllByPath(String path, boolean startsWith);
}
