#!/bin/bash


curl --request POST -sL \
     --url 'http://localhost:8080/clients/'\
     -H "Content-Type: application/json" \
     -d '{"name":"test client 7","email":"test-new7@test.ru"}'

