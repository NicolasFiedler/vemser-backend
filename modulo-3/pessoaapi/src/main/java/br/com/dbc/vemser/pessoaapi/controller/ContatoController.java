package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Log
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

//    public ContatoController () {
//        contatoService = new ContatoService();
//    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoaId (@Valid @PathVariable("idPessoa") Integer id) {
        return contatoService.listByPessoaId(id);
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@Valid @PathVariable("idPessoa") Integer idPessoa, @RequestBody Contato contato) {
        contato.setIdPessoa(idPessoa);
        log.info("Contato Inserido!");
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@Valid @PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoUpdate) throws Exception {
        log.info("Contato Atualizado!");
        return contatoService.update(id, contatoUpdate);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@Valid @PathVariable("idContato") Integer id) throws Exception {
        log.info("Contato Removido!");
        contatoService.delete(id);
    }
}
