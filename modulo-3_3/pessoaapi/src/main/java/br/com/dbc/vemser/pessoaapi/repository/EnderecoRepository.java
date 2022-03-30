package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import com.google.gson.JsonElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select e from endereco_pessoa e where LOWER(e.pais) = LOWER(:pais)")
    List<EnderecoEntity> findEnderecoByPais (String pais);

    @Query("select e from endereco_pessoa e join fetch e.pessoas p where p.idPessoa = ?1")
    List<EnderecoEntity> findEnderecoByIdPessoa (Integer id);

    @Query(value = "SELECT * FROM endereco_pessoa e WHERE e.cidade = :nome OR e.pais = :nome ", nativeQuery = true)
    List<EnderecoEntity> findEnderecoByEstadoPais (String nome);

    @Query(value = "SELECT * FROM endereco_pessoa e WHERE e.complemento is Null", nativeQuery = true)
    List<EnderecoEntity> findEnderecoSemComplemento ();

    Page<EnderecoEntity> findByPais(Pageable pageable, String pais);
}
