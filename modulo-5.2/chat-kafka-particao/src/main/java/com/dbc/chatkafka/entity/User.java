package com.dbc.chatkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum User {

    FELIPE("felipe"),
    NICOLAS("nicolas");

    private final String user;

}
