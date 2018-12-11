#!/bin/bash

curl localhost:8080/v1 | jq .

curl localhost:8080/v1?content=testing | jq .

curl localhost:8080/v1/hell | jq .