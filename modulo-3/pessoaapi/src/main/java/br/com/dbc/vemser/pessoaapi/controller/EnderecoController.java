package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Log
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> get() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO getById(@Valid @PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.getById(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> getByPessoa(@Valid @PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.getByPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Endereco Inserido!");
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@Valid @PathVariable("idEndereco") Integer idEndereco,
                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Endereco Atualizado!");
        return enderecoService.update(idEndereco, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public EnderecoDTO delete(@Valid @PathVariable("idEndereco") Integer id) throws Exception {
        log.info("Endereco Removido!");
        return enderecoService.delete(id);
    }
}
