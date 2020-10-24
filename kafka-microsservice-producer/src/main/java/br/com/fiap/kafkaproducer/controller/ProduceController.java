package br.com.fiap.kafkaproducer.controller;

import br.com.fiap.kafkaproducer.business.ValidaDadosDrone;
import br.com.fiap.kafkaproducer.model.DroneInfo;
import br.com.fiap.kafkaproducer.producer.DroneMessageProducer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@CrossOrigin(origins = "*")
public class ProduceController {

    private DroneMessageProducer droneMessageProducer;

    public ProduceController(DroneMessageProducer droneMessageProducer) {
        this.droneMessageProducer = droneMessageProducer;
    }

    @PostMapping("drone-info")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Mensagem em Json com informações do Drone", response = DroneInfo.class)
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "400", description = "objeto.invalido"),
            }
    )
    public ResponseEntity createProducer(@RequestBody DroneInfo droneInfo) {
        droneMessageProducer.sendMessage(ValidaDadosDrone.validate(droneInfo));
        return ResponseEntity.ok(droneInfo);
    }
}
