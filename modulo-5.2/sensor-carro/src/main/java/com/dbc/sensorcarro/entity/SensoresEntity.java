package com.dbc.sensorcarro.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "sensores")
public class SensoresEntity {
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
