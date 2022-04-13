package com.dbc.sensorcarro.repository;

import com.dbc.sensorcarro.entity.SensoresEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends MongoRepository<SensoresEntity, String> {
}
