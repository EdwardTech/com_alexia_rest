package com.alexia.rest.example.service;

import com.alexia.rest.example.model.Client;

import java.util.Optional;

public interface ClientServiceGetById {

    Optional<Client> read(Long id);

}
