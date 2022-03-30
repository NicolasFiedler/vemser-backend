package br.com.dbc.vemser.pessoaapi.dto.contato;

import br.com.dbc.vemser.pessoaapi.enuns.Tipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoCreateDTO {

    @ApiModelProperty(value = "ID pessoa")
    private Integer idPessoa;

    @ApiModelProperty(value = "Tipo de Contato")
    @NotNull
    private Tipo tipo;

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(min = 9, max = 11)
    private String numeroTelefone;

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(max = 255)
    private String descricao;
}
