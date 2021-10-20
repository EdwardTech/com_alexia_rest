package com.alexia.rest.example.service.client.impl;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;
import com.alexia.rest.example.service.ClientServiceDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceIDeleteImpl implements ClientServiceDelete {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Result delete(Long id) {

        Optional<Client> client = this.clientRepository.findById(id);

        if(!client.isPresent()) {
            return new Result(false);
        }

        clientRepository.deleteById(id);
        System.out.println("client deleted with id: " + id);
        return new Result(true);
    }

}
