package com.dbc.sensorcarro.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensoresCreateDTO {
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
