package br.com.fiap.sistema.drones.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.fiap.sistema.drones.model.DroneInfo;
import br.com.fiap.sistema.drones.service.DroneInfoService;

@Component
public class KafkaConsumerService {

	private final DroneInfoService service;

	public KafkaConsumerService(DroneInfoService service) {
		this.service = service;
	}

	@KafkaListener(topics = "${kafka.drone.info.topic}", containerFactory = "kafkaJsonListenerContainerFactory")
	public void listener(@Payload DroneInfo info) {
		service.save(info);
	}

}
