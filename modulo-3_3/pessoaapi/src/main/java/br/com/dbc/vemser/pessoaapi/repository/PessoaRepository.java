package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeIgnoreCaseContaining(String nome);
    Optional<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate incicio, LocalDate fim);

    @Query("SELECT p FROM PESSOA p WHERE p.dataNascimento BETWEEN :inicio AND :fim")
    List<PessoaEntity> findByBetweenDataNascimentoJPQL ( LocalDate inicio, LocalDate fim);

    @Query("SELECT p FROM PESSOA p JOIN FETCH p.enderecos")
    List<PessoaEntity> pessoasComEndereco ();

    @Query(value = "select * from PESSOA p left join pessoa_x_pessoa_endereco pe on (p.id_pessoa = pe.id_pessoa) where pe.id_pessoa is null", nativeQuery = true)
    List<PessoaEntity> pessoaSemEndereco ();
}