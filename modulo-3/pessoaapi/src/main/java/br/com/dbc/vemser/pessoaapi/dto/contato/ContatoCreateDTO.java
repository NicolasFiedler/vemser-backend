package br.com.dbc.vemser.pessoaapi.dto.contato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoCreateDTO {
    @NotEmpty
    @NotNull
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Max(13)
    private String numeroTelefone;
}
