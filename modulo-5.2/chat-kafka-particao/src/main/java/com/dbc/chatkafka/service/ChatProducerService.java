package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.entity.Topics;
import com.dbc.chatkafka.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarMensagem(User from, String mensagem, Topics[] topics) {if (!Arrays.asList(topics).isEmpty() ) {
            MensagemDTO mensagemDTO = new MensagemDTO(from.getUser(), mensagem, LocalDateTime.now());
            if (Arrays.asList(topics).contains(Topics.GERAL)) {
                enviar(mensagemDTO, Topics.GERAL);
            } else {
                Arrays.stream(topics)
                        .filter(topic -> !topic.getTopic().contains(from.getUser()))
                        .forEach(topic -> enviar(mensagemDTO, topic));
            }
        } else {
            log.error("Nenhum usuario selecionado.");
        }
    }

    private void enviar (MensagemDTO mensagem, Topics topic) {
        String mensagemJson = null;
        try {
            mensagemJson = objectMapper.writeValueAsString(mensagem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (mensagemJson != null){
            Message<String> message = MessageBuilder.withPayload(mensagemJson)
                    .setHeader(KafkaHeaders.TOPIC, "chat-marcar-churrasco")
                    .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                    .setHeader(KafkaHeaders.PARTITION_ID, topic.ordinal())
                    .build();

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

            String finalMensagemJson = mensagemJson; //o java manda a gente faz sksksksk
            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult result) {

                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", finalMensagemJson, ex);
                }
            });
        }
    }
}
