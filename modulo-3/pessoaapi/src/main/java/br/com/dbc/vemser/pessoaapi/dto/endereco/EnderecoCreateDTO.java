package br.com.dbc.vemser.pessoaapi.dto.endereco;

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
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Max(250)
    private String logradouro;
    @NotEmpty
    @NotNull
    private Integer numero;
    @NotEmpty
    @NotNull
    @Max(250)
    private String cidade;
    @NotEmpty
    @NotNull
    @Max(8)
    private String cep;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
