package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceGetAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/clients/")
public class ClientControllerGetAll {

    private final ClientServiceGetAll clientServiceGetAll;

    @Autowired
    public ClientControllerGetAll(ClientServiceGetAll clientServiceGetAll) {
        this.clientServiceGetAll = clientServiceGetAll;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClients = this.clientServiceGetAll.readAll();

        if(allClients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }




}

