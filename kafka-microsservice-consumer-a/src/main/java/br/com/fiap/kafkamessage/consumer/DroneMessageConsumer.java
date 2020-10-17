package br.com.fiap.kafkamessage.consumer;

import br.com.fiap.kafkamessage.dto.DroneInfoDTO;
import br.com.fiap.kafkamessage.model.DroneInfo;
import br.com.fiap.kafkamessage.service.DroneInfoDTOService;
import br.com.fiap.kafkamessage.service.EmailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class DroneMessageConsumer {

    private CountDownLatch droneLatch = new CountDownLatch(1);
    private EmailService emailService;
    private DroneInfoDTOService droneInfoDTOService;
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(DroneMessageConsumer.class  );

    public DroneMessageConsumer(EmailService emailService, DroneInfoDTOService droneInfoDTOService, ModelMapper modelMapper) {
        this.emailService = emailService;
        this.droneInfoDTOService = droneInfoDTOService;
        this.modelMapper = modelMapper;
        this.threadEnvioEmail();
    }

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "droneInfoKafkaListenerContainerFactory")
    public void droneInfoListener(DroneInfo droneInfo) throws InterruptedException {

        int temperatura = Integer.parseInt(droneInfo.getTemperatura());
        int umidade = Integer.parseInt(droneInfo.getUmidade());

        if ( (temperatura >= 35 || temperatura <= 0)  || umidade <= 15 ) {
            DroneInfoDTO droneInfoDTOSaved = modelMapper.map(droneInfo, DroneInfoDTO.class);
            droneInfoDTOSaved.setStatus(false);
            droneInfoDTOService.save(droneInfoDTOSaved);
        }
        this.droneLatch.await(5, TimeUnit.SECONDS);
    }

    private void threadEnvioEmail() {
        Runnable runnable = () -> {
            while(true) {
                List<DroneInfoDTO> listDrones = droneInfoDTOService.getAllByStatus();
                try {
                    if (!listDrones.isEmpty()) {
                        for (DroneInfoDTO drone : listDrones) {
                            emailService.sendSimpleMessage(drone.getEmail(), "MONITORAMENTO DRONE", drone.toString());
                            logger.info("email enviado -> " + drone.getEmail());
                            drone.setStatus(true);
                            droneInfoDTOService.save(drone);
                        }
                    } else {
                        logger.info("não há email a ser enviado");
                    }
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
