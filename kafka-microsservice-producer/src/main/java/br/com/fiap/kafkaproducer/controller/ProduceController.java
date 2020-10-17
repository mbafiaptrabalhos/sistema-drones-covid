package br.com.fiap.kafkaproducer.controller;

import br.com.fiap.kafkaproducer.model.DroneInfo;
import br.com.fiap.kafkaproducer.producer.DroneMessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@CrossOrigin(origins = "*")
public class ProduceController {

    private DroneMessageProducer droneMessageProducer;

    public ProduceController(DroneMessageProducer droneMessageProducer) {
        this.droneMessageProducer = droneMessageProducer;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducer(@RequestBody DroneInfo droneInfo) {
        droneMessageProducer.sendMessage(droneInfo);
    }
}
