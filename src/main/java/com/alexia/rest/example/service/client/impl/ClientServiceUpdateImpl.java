package com.alexia.rest.example.service.client.impl;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import com.alexia.rest.example.service.ClientServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceUpdateImpl implements ClientServiceUpdate {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Result update(Client client) {

        Optional<Client> clientOptional = this.clientRepository.findById(client.getId());

        if(! clientOptional.isPresent()) {
            return new Result(false);
        }
        clientRepository.save(client);
        return new Result(true);
    }

}
