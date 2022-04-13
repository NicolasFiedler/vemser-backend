package com.dbc.sensorcarro.service;

import com.dbc.sensorcarro.dto.InfoDTO;
import com.dbc.sensorcarro.dto.SensoresDTO;
import com.dbc.sensorcarro.entity.SensoresEntity;
import com.dbc.sensorcarro.repository.SensorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeituraSensoresService {
    private final SensorRepository sensorRepository;
    private final ObjectMapper objectMapper;

    public List<SensoresDTO> findAll () {
        return sensorRepository.findAll().stream()
                .map(sensoresEntity -> objectMapper.convertValue(sensoresEntity, SensoresDTO.class))
                .collect(Collectors.toList());
    }

    public InfoDTO infoVeiculo () {
        List<SensoresEntity> sensoresEntities = sensorRepository.findAll();

        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setRotacaoMedia(sensoresEntities.stream()
                .map(sensoresEntity -> ));
        for (SensoresEntity sensor : sensoresEntities) {

        }
    }

}
