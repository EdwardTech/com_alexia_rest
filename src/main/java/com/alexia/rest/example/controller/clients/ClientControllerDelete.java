package com.alexia.rest.example.controller.clients;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.service.ClientServiceDelete;
import com.alexia.rest.example.service.ClientServiceGetById;
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
public class ClientControllerDelete {

    private final ClientServiceDelete clientServiceDelete;
    private final ClientServiceGetById clientServiceGetById;

    public ClientControllerDelete(
            ClientServiceDelete clientServiceDelete,
            ClientServiceGetById clientServiceGetById) {
        this.clientServiceDelete = clientServiceDelete;
        this.clientServiceGetById = clientServiceGetById;
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") long id) {
        Optional<Client> client = this.clientServiceGetById.read(id);

        if(!client.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.clientServiceDelete.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}

