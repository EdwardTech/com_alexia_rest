package com.alexia.rest.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexia.rest.example.model.Client;

/**
 * Для взаимодействия с БД
 */

public interface ClientRepository extends CrudRepository<Client, Long> { }
