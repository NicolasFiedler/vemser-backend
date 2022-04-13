package com.dbc.sensorcarro.controller;

import com.dbc.sensorcarro.dto.SensoresDTO;
import com.dbc.sensorcarro.repository.SensorRepository;
import com.dbc.sensorcarro.service.LeituraSensoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leitura-sensores-carro")
@RequiredArgsConstructor
public class LeituraSensoresController {

    private final LeituraSensoresService LeituraSensoresService;

    @GetMapping("/")
    public List<SensoresDTO> getLeituras () {
        return LeituraSensoresService.findAll();
    }
}
