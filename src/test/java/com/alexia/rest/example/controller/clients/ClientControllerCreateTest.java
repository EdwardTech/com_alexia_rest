package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import org.junit.jupiter.api.Test;
import com.alexia.rest.example.service.ClientServiceCreate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerCreateTest {

    @Test
    void createClient() {
        ClientControllerCreate clientCreate = clientController();
    }

    @Test
    void createClientFailed() {

    }

    private ClientControllerCreate clientController() {
        return new ClientControllerCreate(clientServiceCreate());
    }


    private ClientServiceCreate clientServiceCreate() {
        return new ClientServiceCreate() {
            @Override
            public Result create(Client client) {
                return null;
            }
        };
    }


}
