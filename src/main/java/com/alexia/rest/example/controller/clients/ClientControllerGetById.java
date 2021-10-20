package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/clients/")
public class ClientControllerGetById {

    private final ClientServiceGetById clientServiceGetById;

    @Autowired
    public ClientControllerGetById(
            ClientServiceGetById clientServiceGetById) {
        this.clientServiceGetById = clientServiceGetById;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getClient(@PathVariable("id") Long id) {

        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Client> clientOptional = this.clientServiceGetById.read(id);

        return clientOptional
                .map( cl -> new ResponseEntity(cl, HttpStatus.OK))
                .orElseGet( () -> new ResponseEntity("{\"message\": \"Client not found\"}",HttpStatus.NOT_FOUND));

    }

}

