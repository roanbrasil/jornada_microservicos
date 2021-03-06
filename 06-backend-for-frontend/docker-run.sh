#!/bin/bash

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] BUILD - MICROSSERVICOS"
echo "[INFO] ------------------------------------------------------------------------"
mvn clean package;

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] UP CONTAINERS"
echo "[INFO] ------------------------------------------------------------------------"
docker-compose up -d --build;
