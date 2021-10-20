package com.alexia.rest.example.controller;

import com.alexia.rest.example.model.Client;
import com.alexia.rest.example.repository.ClientRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Поведение репозитория сымитировано
    @MockBean
    private ClientRepository clientRepository;

    @Test
    void getClient() throws Exception {

    }

    @Test
    void getAllClients() {

    }

    @Test
    public void createClient() throws Exception {
        Client client = new Client("Test-firstName-controller", "Test-lastName-controller", "Test-email-controller", "Test-phone-controller");
        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);
        // Cоздаем юзера и отправляем фейковый пост запрос преобразовав запрос в json-строку
        mockMvc.perform(
                        post("/clients/")
                                .content(objectMapper.writeValueAsString(client))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                // проверяем код ответа и получаем клиента
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(client)));
    }

    @Test
    void deleteClient() {
    }

    @Test
    void updateClient() {
    }
}