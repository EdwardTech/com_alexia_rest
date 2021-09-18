#!/bin/bash


curl --request POST -sL \
     --url 'http://localhost:9967/clients/'\
     -H "Content-Type: application/json" \
     -d '{"firstName": "TEST", "lastName": "EGEG", "email": "elin291@yandex.ru", "phone":"+7-924-318-10-74"}'

