package com.dbc.sensorcarro.controller;


import com.dbc.sensorcarro.dto.SensoresCreateDTO;
import com.dbc.sensorcarro.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensores-carro")
@RequiredArgsConstructor
public class SensoresCarroController {
    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    private void enviar(SensoresCreateDTO mensagem) throws JsonProcessingException {
        produtorService.enviarMensagem(mensagem);
    }
}

