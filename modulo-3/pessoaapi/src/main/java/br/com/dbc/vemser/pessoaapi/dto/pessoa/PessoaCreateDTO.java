package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaCreateDTO {

    @NotEmpty
    private String nome;
    @Past
    private LocalDate dataNascimento;
    @Email
    private String email;
    @CPF
    private String cpf;
}
