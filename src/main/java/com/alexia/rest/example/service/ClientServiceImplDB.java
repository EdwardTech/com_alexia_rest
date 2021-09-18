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
    public Result update(Client client) {

        Optional<Client> clientOptional = this.clientRepository.findById(client.getId());

        if(! clientOptional.isPresent()) {
            System.out.println("you will not upgrade this client. Client with id: " + client.getId() + " no such");
            return new Result(false);
        }
        clientRepository.save(client);
        System.out.println("client with id: "  + client.getId() + " was updated");
        return new Result(true);
    }

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

    @Override
    public Result create(Client client) {
        client.setId(null);
        clientRepository.save(client);
        return new Result(true);

    }

    @Override
    public Optional<Client> read(Long id) {
        final Optional<Client> client = clientRepository.findById(id);

        if(!client.isPresent()) {
            System.out.println("you will not get this client. there is no such client");
            return client;
        }

        System.out.println("read one");
        return client;
    }

    @Override
    public List<Client> readAll() {
        System.out.println("read all");
        Iterable<Client> all = clientRepository.findAll();
        List<Client> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }
}
