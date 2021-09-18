#!/bin/bash


curl --request PUT -sL \
     --url 'http://localhost:9967/clients/1'\
     -H "Content-Type: application/json" \
     -d '{"firstName": "123", "lastName": "123", "email": "elin291@yandex.ru", "phone":"+7-924-318-10-74"}'

