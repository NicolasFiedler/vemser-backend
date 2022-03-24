package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.enuns.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    @Query("select c from CONTATO c where c.tipo = :tipo")
    List<ContatoEntity> findByTipoContato (Tipo tipo);

    @Query(value = "select * from CONTATO c where c.id_pessoa = :id", nativeQuery = true)
    List<ContatoEntity> findByIdPessoa (Integer id);
}
