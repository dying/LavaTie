package com.dabbotorg.lavatie.client.api;

import com.dabbotorg.lavatie.commons.data.Repository;

import java.io.IOException;
import java.util.List;

public interface ClientRepository extends Repository<Client> {
    Client findOneByPath(String path) throws IOException;
    List<? extends Client> findAllByPath(String path, boolean startsWith);
}
