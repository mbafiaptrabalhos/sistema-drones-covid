package br.com.fiap.sistema.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class KafkaMicrosserviceConsumerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMicrosserviceConsumerBApplication.class, args);
    }

}
