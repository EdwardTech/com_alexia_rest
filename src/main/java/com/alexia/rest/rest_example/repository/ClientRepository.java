package com.alexia.rest.rest_example.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexia.rest.rest_example.model.Client;

/**
 * Для взаимодействия с БД
 */

public interface ClientRepository extends CrudRepository<Client, Long> {
}
