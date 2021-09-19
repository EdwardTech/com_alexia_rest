package com.alexia.rest.example.service;

import com.alexia.rest.example.model.Client;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceImplDBTest {

    @Autowired
    ClientService clientService;

    @Test
    void update() {
        Client client = new Client();
        client.setId((long) 3);
        client.setFirstName("Update CLient");
        client.setLastName("Update CLient");
        client.setPhone("default value");
        client.setEmail("default value");

        ClientService.Result clientUpdate = this.clientService.update(client);

        boolean isUpdate = false;

        if(clientUpdate.isSuccess() == true) {
            isUpdate = true;
        }

        Assert.assertTrue(isUpdate);

    }

    @Test
    void create() {
        Client client = new Client();
        client.setEmail("ggesgse");
        client.setPhone("891728714");
        client.setFirstName("Igor");
        client.setLastName("Igor");

        ClientService.Result clientCreat = clientService.create(client);

        boolean isCreated = false;

        if(clientCreat.isSuccess() == true) {
            System.out.println("Success");
            isCreated = true;
        }

        Assert.assertTrue(isCreated);

    }

    @Test
    void read() {
        Optional<Client> clientIsRead = this.clientService.read((long) 3);

        boolean isRead = false;

        if(clientIsRead.isPresent()) {
            isRead = true;
        }

        Assert.assertTrue(isRead);
    }



    @Test
    void delete() {
        ClientService.Result clientIsDelete = this.clientService.delete((long) 5);

        boolean isDeleted = false;

        if(clientIsDelete.isSuccess() == true) {
            isDeleted = true;
        }

        Assert.assertTrue(isDeleted);


    }
}