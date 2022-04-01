package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.GrupoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoEntity findById (Integer id) throws RegraDeNegocioException {
        return grupoRepository.findById(id)
                .orElseThrow( () -> new RegraDeNegocioException("Grupo nao encontrado"));
    }

//    public GrupoEntity findByNome (String nome) throws RegraDeNegocioException {
//        return grupoRepository.findByNomeIgnoreCase(nome)
//                .orElseThrow( () -> new RegraDeNegocioException("Grupo nao encontrado"));
//    }
}
