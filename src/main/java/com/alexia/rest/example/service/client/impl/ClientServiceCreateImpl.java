package com.alexia.rest.example.service.client.impl;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import com.alexia.rest.example.service.ClientServiceCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceCreateImpl implements ClientServiceCreate {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Result create(Client client) {
        client.setId(null);
        clientRepository.save(client);
        return new Result(true);

    }

}
