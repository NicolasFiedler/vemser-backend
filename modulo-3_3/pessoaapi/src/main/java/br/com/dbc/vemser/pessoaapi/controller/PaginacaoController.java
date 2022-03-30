package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paginacao")
public class PaginacaoController {
    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;

    @GetMapping("/contatos-ordenados-por-descricao")
    public Page<ContatoEntity> contatosPorDescricao (Integer paginaSolicitada, Integer tamanhoPagina) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("descricao"));
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-ordenados-por-cep")
    public Page<EnderecoEntity> enderecosPorCEP (Integer paginaSolicitada, Integer tamanhoPagina) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("cep"));
        return enderecoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-filtrado-por-pais")
    public Page<EnderecoEntity> enderecosFindPais (@RequestParam("pais") String pais, @RequestParam("paginaSolicitada") Integer paginaSolicitada, @RequestParam("tamanhoPagina") Integer tamanhoPagina) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina);
        return enderecoRepository.findByPais(pageable, pais);
    }
}
