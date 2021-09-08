package com.alexia.rest.example.service;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Client> read(Long id) {
        final Optional<Client> client = clientRepository.findById(id);
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
