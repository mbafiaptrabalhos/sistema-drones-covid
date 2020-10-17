package br.com.fiap.kafkamessage.service.impl;

import br.com.fiap.kafkamessage.dto.DroneInfoDTO;
import br.com.fiap.kafkamessage.repository.DroneInfoDTORepository;
import br.com.fiap.kafkamessage.service.DroneInfoDTOService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneInfoDTOServiceImpl implements DroneInfoDTOService {

    private DroneInfoDTORepository repository;

    public DroneInfoDTOServiceImpl(DroneInfoDTORepository repository) {
        this.repository = repository;
    }

    @Override
    public DroneInfoDTO save(DroneInfoDTO droneInfoDTO) {
        return repository.save(droneInfoDTO);
    }

    @Override
    public List<DroneInfoDTO> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DroneInfoDTO> getAllByStatus() {
        return repository.findAllByStatusIsFalse();
    }

    @Override
    public void updateDroneInfoDto(DroneInfoDTO droneInfoDTO) {
        repository.save(droneInfoDTO);
    }
}
