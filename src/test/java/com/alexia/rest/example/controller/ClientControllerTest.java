package com.alexia.rest.example.controller;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    @Autowired
    ClientService clientService;

    @Test
    void getClient() {
    }

    @Test
    void getAllClients() {
        List<Client> allClients = this.clientService.readAll();

        for (Client client: allClients) {
            System.out.println(client);
        }
    }

    @Test
    void createClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void updateClient() {
    }
}