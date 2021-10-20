package com.alexia.rest.example.service;

import com.alexia.rest.example.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientServiceUpdate {

    Result update(Client client);

    class Result {
        private final boolean success;

        public Result(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }

}
