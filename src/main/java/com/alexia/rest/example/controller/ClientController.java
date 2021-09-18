package com.alexia.rest.example.controller;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getClient(@PathVariable("id") Long id) {

        Optional<Client> client = this.clientService.read(id);

        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("{\"message\": \"Client not found\"}",HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClients = this.clientService.readAll();

        if(allClients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> createClient (@RequestBody @Validated Client client) {
        HttpHeaders headers = new HttpHeaders();

        if(client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ClientService.Result addNewClient = this.clientService.create(client);
        if(addNewClient.isSuccess()) {
            return new ResponseEntity<>(client, headers, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") long id) {
        Optional<Client> client = this.clientService.read(id);

        if(!client.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.clientService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody @Validated Client client, UriComponentsBuilder builder) {
        if(client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        client.setId(id);

        ClientService.Result updateRes = this.clientService.update(client);

        if(updateRes.isSuccess()) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


}

