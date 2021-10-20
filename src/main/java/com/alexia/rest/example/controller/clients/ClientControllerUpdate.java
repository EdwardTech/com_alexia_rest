package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/clients/")
public class ClientControllerUpdate {

    private final ClientServiceUpdate clientServiceUpdate;

    public ClientControllerUpdate(ClientServiceUpdate clientServiceUpdate) {
        this.clientServiceUpdate = clientServiceUpdate;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody @Validated Client client, UriComponentsBuilder builder) {
        if(client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        client.setId(id);

        ClientServiceUpdate.Result updateRes = this.clientServiceUpdate.update(client);

        if(updateRes.isSuccess()) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


}

