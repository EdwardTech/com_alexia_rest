package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceGetById;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

class ClientControllerByHandTest {

    @Test
    void getClientOk() {
        ClientControllerGetById subj = clientControllerGet();
        ResponseEntity client = subj.getClient(1L);
        System.out.println(client.getStatusCode());
        Assertions.assertEquals(200, client.getStatusCode().value());
    }

    @Test
    void getClient404() {
        ClientControllerGetById subj = clientControllerGet();
        ResponseEntity client = subj.getClient(200L);
        System.out.println(client.getStatusCode());
        Assertions.assertEquals(404, client.getStatusCode().value());
    }

    private ClientControllerGetById clientControllerGet() {
        return new ClientControllerGetById(clientServiceGetById());
    }

    private ClientServiceGetById clientServiceGetById() {
        return new ClientServiceGetById() {
            @Override
            public Optional<Client> read(Long id) {
                if ( id == 1L) {
                    return Optional.of(new Client().setFirstName("Kent").setLastName("Beck"));
                } else {
                    return Optional.empty();
                }
            }
        };
    }

    private ClientServiceGetById clientServiceGetByIdv2() {
        return ( id ) -> {
            if ( id == 1L) {
                return Optional.of(new Client().setFirstName("Kent").setLastName("Beck"));
            } else {
                return Optional.empty();
            }

        };
    }

}

