package com.alexia.rest.example.service.client.impl;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import com.alexia.rest.example.service.ClientServiceGetById;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientServiceGetByIdImpl implements ClientServiceGetById {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Optional<Client> read(Long id) {

        return clientRepository.findById(id);

    }
}
