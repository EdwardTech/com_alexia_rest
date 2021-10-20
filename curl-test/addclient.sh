#!/bin/bash


curl --request POST -sL \
     --url 'http://localhost:9967/clients/'\
     -H "Content-Type: application/json" \
     -d '{"firstName": "TEST2", "lastName": "TEST2", "email": "test@test.ru", "phone":"+7-924-318-10-74"}'

