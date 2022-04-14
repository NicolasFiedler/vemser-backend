package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.entity.Topics;
import com.dbc.chatkafka.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ChatConsumerService {

    private final ObjectMapper objectMapper;

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    @KafkaListener(
            groupId = "nicolas",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "nicolasGeral",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})})
    public void consumeGeralNicolas(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(message, MensagemDTO.class);
        if (!mensagemDTO.getUsuario().equals(User.NICOLAS.getUser())){
            System.out.println("\nUsuario: Nicolas\n" + DATE_TIME_FORMATTER.format(mensagemDTO.getDataCriacao()) + " " + mensagemDTO.getUsuario() + ": " + mensagemDTO.getMensagem() + "\n");
        }
    }

    @KafkaListener(
            groupId = "nicolas",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "nicolasPrivado",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"12"})})
    public void consumeNicolas(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(message, MensagemDTO.class);
        System.out.println("\nUsuario: Nicolas\n"+ DATE_TIME_FORMATTER.format(mensagemDTO.getDataCriacao())+" "+mensagemDTO.getUsuario()+"(privada): "+mensagemDTO.getMensagem()+"\n");
    }

    @KafkaListener(
            groupId = "felipe",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "felipeGeral",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})})
    public void consumeGeralFelipe(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(message, MensagemDTO.class);
        if (!mensagemDTO.getUsuario().equals(User.FELIPE.getUser())){
            System.out.println("\nUsuario: Felipe\n" + DATE_TIME_FORMATTER.format(mensagemDTO.getDataCriacao()) + " " + mensagemDTO.getUsuario() + ": " + mensagemDTO.getMensagem() + "\n");
        }
    }

    @KafkaListener(
            groupId = "felipe",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "felipePrivado",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"3"})})
    public void consumeFelipe(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(message, MensagemDTO.class);
        System.out.println("\nUsuario: Felipe\n"+ DATE_TIME_FORMATTER.format(mensagemDTO.getDataCriacao())+" "+mensagemDTO.getUsuario()+"(privada): "+mensagemDTO.getMensagem()+"\n");
    }
}
