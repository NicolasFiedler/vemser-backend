package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> get() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco getById(@Valid @PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.getById(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> getByPessoa(@Valid @PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.getByPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                           @Valid @RequestBody Endereco endereco) {
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@Valid @PathVariable("idEndereco") Integer idEndereco,
                           @Valid @RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(idEndereco, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public Endereco delete(@Valid @PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.delete(id);
    }
}
