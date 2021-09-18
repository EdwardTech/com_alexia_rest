package com.alexia.rest.example.service;
import com.alexia.rest.example.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    Result create(Client client);

    List<Client> readAll();

    Optional<Client> read(Long id);

    Result update(Client client);


    Result delete(Long id);

    class Result {
        private final boolean success;

        Result(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }

}
