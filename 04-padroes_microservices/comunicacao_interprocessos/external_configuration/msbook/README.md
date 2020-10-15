# Exemplo de External Configuration - Config Server

Autores: Carmem Pereira e Natália Rosa

## Pré-requisitos 

- Java 8
- Maven

## Exemplo de código usando Spring (local yaml)

Neste exemplo, estamos configurando a porta e nome do microsserviço conforme o ambiente de desenvolvimento, teste e produção.

Foram criados quatro arquivos YAML com as configurações e uma classe que mapeia estas configurações.


- application.yml - define qual ambiente está ativo e contém as configurações genéricas aplicadas a todos os ambientes
spring:

- application-dev.yml - contém as configurações específicas do ambiente de desenvolvimento

- application-qa.yml - contém as configurações específicas do ambiente de teste
	
- application-prod.yml - contém as configurações específicas do ambiente de produção

## Start
```
mvn install
```

```
mvn spring-boot:run
```
