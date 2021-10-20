package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceCreate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients/")
public class ClientControllerCreate {

    private final ClientServiceCreate clientServiceCreate;

    public ClientControllerCreate(ClientServiceCreate clientServiceCreate) {
        this.clientServiceCreate = clientServiceCreate;
    }




    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> createClient (@RequestBody @Validated Client client) {
        HttpHeaders headers = new HttpHeaders();

        if(client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ClientServiceCreate.Result addNewClient = this.clientServiceCreate.create(client);
        if(addNewClient.isSuccess()) {
            return new ResponseEntity<>(client, headers, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}

