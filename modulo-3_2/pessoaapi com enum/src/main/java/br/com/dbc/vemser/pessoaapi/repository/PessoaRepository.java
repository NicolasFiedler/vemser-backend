package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeIgnoreCaseContaining(String nome);
    Optional<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate incicio, LocalDate fim);

}