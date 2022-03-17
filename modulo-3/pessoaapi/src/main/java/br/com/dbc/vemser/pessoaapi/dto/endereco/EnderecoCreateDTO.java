package br.com.dbc.vemser.pessoaapi.dto.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 250)
    private String cidade;
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
