package com.alexia.rest.rest_example.service;

import com.alexia.rest.rest_example.model.Client;
import com.alexia.rest.rest_example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImplDB implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    // Ниже реализуем методы


    @Override
    public boolean update(Client client, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void create(Client client) {
        client.setId(null);
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> read(int id) {
        Long idClient = (long) id;
        final Optional<Client> client = clientRepository.findById(idClient);
        return client;
    }

    @Override
    public List<Client> readAll() {
        Iterable<Client> all = clientRepository.findAll();
        List<Client> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }
}
