package com.dbc.chatkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Topics {

    GERAL("chat-geral"),
    ANA("chat-ana"),
    EZEQUIAS("chat-ezequias"),
    FLAVIO("chat-flavio"),
    GABRIEL("chat-gabriel"),
    GUILHERME("chat-guilherme"),
    GUSTAVO("chat-gustavo"),
    JOAO("chat-joao"),
    LUCAS("chat-lucas"),
    LUIZ("chat-luiz"),
    MAICON("chat-maicon"),
    PABLO("chat-pablo");

    private final String topic;

}
