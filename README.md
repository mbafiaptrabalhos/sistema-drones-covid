
![Logo of the project](https://github.com/mbafiaptrabalhos/sistema-drones/blob/develop/index/assets/droneBranco.png)

  

# Sistema Drone

> Projeto criado para a disciplina de Webservices and Restful Technologies [FIAP].

 
Sistema é uma solução para coleta de dados de localização em tempo real de drones responsáveis por limpeza de ambientes. 
De minuto em minuto o sistema envia um e-mail com as informações dos drones cadastrados, desde que a temperatura seja maior ou igual a 35, menor ou igual a 0, ou que a umidade do ar seja menor ou igual a 15%.


![diagrama](diagrama.png)
  

## Integrantes

  

- Caroline Nascimento de Oliveira - 337401

- Harold Isaac Campero Stoffers Murillo - 337233

- Jonathas da Cruz Garcia - 338900

- Renato Santana Brito - 337364

- Victor Tokudo Kiam - 337385

  

## Iniciando o projeto

  

Essas são as configurações necessárias para que possa rodar o projeto.

  

```shell

- Java
- Docker
- Maven

```

  

### Baixar o projeto

  

Siga as orientações para baixar o projeto na sua máquina.

  

```shell

git clone https://github.com/mbafiaptrabalhos/sistema-drones-covid.git

```

  

### Running  

Para executar o projeto você deve.
  
  Executar comando abaixo na pasta raíz para executar **Kafka** pelo docker:
  ```shell
docker-compose up -d
```

Acessar pasta do microservice **kafka-microsservice-producer** e executar comando:

```shell
mvn spring-boot:run
```
Acessar pasta do microservice **kafka-microsservice-consumer-a** e executar comando:

```shell
mvn spring-boot:run
```

Acessar pasta do microservice **kafka-microsservice-consumer-a** e executar comando:

```shell
mvn spring-boot:run
```
  
