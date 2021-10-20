package com.alexia.rest.example.service.client.impl;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import com.alexia.rest.example.service.ClientServiceGetAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientServiceGetAllImpl implements ClientServiceGetAll {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> readAll() {
        Iterable<Client> all = clientRepository.findAll();
        List<Client> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }
}
