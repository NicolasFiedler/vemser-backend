package br.com.dbc.vemser.pessoaapi.dto.endereco;

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
public class EnderecoCreateDTO {

    @ApiModelProperty(value = "Tipo de endereco (RESIDENCIAL || COMERCIAL)")
    @NotNull
    @Max(2)
    private Integer tipo;

    @ApiModelProperty(value = "rua || avenida || adress")
    @NotEmpty
    @Size(min = 1, max = 200)
    private String logradouro;

    @ApiModelProperty(value = "Numerod do endereco")
    @NotNull
    private Integer numero;

    @ApiModelProperty(value = "apartamento, porta...")
    @NotEmpty
    @Size(max = 200)
    private String complemento;

    @ApiModelProperty(value = "Codigo Postal")
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @ApiModelProperty(value = "Cidade/Municipio")
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 250)
    private String cidade;

    @ApiModelProperty(value = "Estado")
    @NotNull
    private String estado;

    @ApiModelProperty(value = "Pais")
    @NotNull
    private String pais;
}
