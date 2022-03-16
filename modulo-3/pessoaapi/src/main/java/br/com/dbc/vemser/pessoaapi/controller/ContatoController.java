package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private ObjectMapper objectMapper;

//    public ContatoController () {
//        contatoService = new ContatoService();
//    }

    @GetMapping
    public List<ContatoDTO> list() {
        log.info("Listar Contato");
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoaId (@Valid @PathVariable("idPessoa") Integer id) {
        log.info("Listar Contatos por Pessoa");
        return contatoService.listByPessoaId(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@Valid @PathVariable("idPessoa") Integer idPessoa, @RequestBody ContatoCreateDTO contato) {
        contato.setIdPessoa(idPessoa);
        log.info("Inserir Contato");
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public ContatoDTO update(@Valid @PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoCreateDTO contatoUpdate) throws Exception {
        log.info("Atualizar Contato");
        return contatoService.update(id, contatoUpdate);
    }

    @DeleteMapping("/{idContato}")
    public ContatoDTO delete(@Valid @PathVariable("idContato") Integer id) throws Exception {
        log.info("Remover Contato");
        return contatoService.delete(id);
    }
}
