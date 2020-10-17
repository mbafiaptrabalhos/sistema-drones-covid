
![Logo of the project](https://github.com/mbafiaptrabalhos/sistema-drones/blob/develop/index/assets/droneBranco.png)

  

# Sistema Drone

> Projeto criado para a disciplina de Integration and development tools [FIAP].

  

Esse sistema é um solução para coleta de dados de temperatura e umidade via "drone", a cada 10 segundos é enviado para o message broker os dados da temperatura e de umidade,

além disso é possível acionar o rastreamento do drone no mapa localizado no sistema.

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

git clone https://github.com/mbafiaptrabalhos/sistema-drones.git

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
  

## Vídeo de execução

  

O vídeo abaixo contém a execução dos microsserviços e o funcionamento do sistema.

![video](video.gif)

```shell

https://youtu.be/3iSvBZwKLus

```