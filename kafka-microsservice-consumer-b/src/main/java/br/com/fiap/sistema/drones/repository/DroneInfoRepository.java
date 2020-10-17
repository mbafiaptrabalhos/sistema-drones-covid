package br.com.fiap.sistema.drones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.sistema.drones.model.DroneInfo;

@Repository
public interface DroneInfoRepository extends MongoRepository<DroneInfo, String> {

}
