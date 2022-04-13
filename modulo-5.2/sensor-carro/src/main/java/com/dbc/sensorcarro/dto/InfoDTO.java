package com.dbc.sensorcarro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoDTO {
    private Double velocidadeMedia;
    private Double rotacaoMedia;
    private Integer leituras;
}
