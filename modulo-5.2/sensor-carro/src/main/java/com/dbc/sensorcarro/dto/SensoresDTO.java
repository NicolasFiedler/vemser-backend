package com.dbc.sensorcarro.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensoresDTO extends SensoresCreateDTO{
    LocalDateTime dataLeitura;
}
