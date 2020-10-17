package br.com.fiap.kafkaproducer.producer;

import br.com.fiap.kafkaproducer.model.DroneInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DroneMessageProducer {

    @Value(value = "${kafka.topic}")
    private String topicName;

    private KafkaTemplate<String, DroneInfo> droneInfoKafkaTemplate;


    public DroneMessageProducer(KafkaTemplate<String, DroneInfo> droneInfoKafkaTemplate) {
        this.droneInfoKafkaTemplate = droneInfoKafkaTemplate;
    }

    public void sendMessage(DroneInfo droneInfo) {
        droneInfoKafkaTemplate.send(topicName, droneInfo);
    }
}
