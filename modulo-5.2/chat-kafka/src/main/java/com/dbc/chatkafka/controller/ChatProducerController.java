package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.entity.Topics;
import com.dbc.chatkafka.entity.User;
import com.dbc.chatkafka.service.ChatProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatProducerController {

    private final ChatProducerService chatProducerService;

    @PostMapping("/")
    public void enviarMensagem (@RequestParam User from, @RequestBody String messege, @RequestParam Topics[] to) {
        chatProducerService.enviarMensagem(from, messege, to);
    }
}
