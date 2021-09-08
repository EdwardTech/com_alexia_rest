package com.alexia.rest.example.controller;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity read(@PathVariable("id") Long id) {

        Optional<Client> client = this.clientService.read(id);

        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("{\"message\": \"Client not found\"}",HttpStatus.NOT_FOUND);
    }

}
