package com.alexia.rest.rest_example.service;
import com.alexia.rest.rest_example.model.Client;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService{
    // Хранилище клиентов
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента

    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @PostConstruct
    public void fillClients() {
        System.out.println("fill client call");

        Client client1 = new Client();
        client1.setName("Test");
        client1.setEmail("test@test.ru");

        Client client2 = new Client();
        client2.setName("Test2");
        client2.setEmail("test2@test.ru");

        create(client1);
        create(client2);
    }

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        client.setPhone("8-999-999-99-99");
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }
    @Override
    public boolean update(Client client, int id) {
        if(CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
