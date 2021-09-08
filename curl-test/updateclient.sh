#!/bin/bash


curl --request PUT -sL \
     --url 'http://localhost:8080/clients/1'\
     -H "Content-Type: application/json" \
     -d '{"name":"TestUpdateNew","email":"test4@test.ru","phone":"+7-999-999-99-99"}'

