package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO getById(Integer id) throws Exception {
        return objectMapper.convertValue(list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado.")), EnderecoDTO.class);
    }

//    public List<EnderecoDTO> getByPessoa(Integer id) throws Exception {
//        return list().stream()
//                .filter(e -> e.getIdPessoa().equals(id))
//                .map(e -> objectMapper.convertValue(e, EnderecoDTO.class))
//                .toList();
//    }

//    public EnderecoDTO create(Integer id, EnderecoCreateDTO endereco) throws Exception {
//        endereco.setIdPessoa(id);
//        EnderecoEntity e = enderecoRepository.create(objectMapper.convertValue(endereco, EnderecoEntity.class));
//        if (e != null){
//            emailService.sendEmail(pessoaService.getPessoaById(id), "Novo endereco adicionado!", "email-template-cria-endereco.ftl");
//        }
//        return objectMapper.convertValue(e, EnderecoDTO.class);
//    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws Exception {
        return enderecoRepository.findById(id)
                .map(enderecoEntity -> {

                    enderecoEntity.setTipo(endereco.getTipo());
                    enderecoEntity.setLogradouro((endereco.getLogradouro()));
                    enderecoEntity.setNumero(endereco.getNumero());
                    enderecoEntity.setComplemento(endereco.getComplemento());
                    enderecoEntity.setCep(endereco.getCep());
                    enderecoEntity.setEstado(endereco.getEstado());
                    enderecoEntity.setCidade(endereco.getCidade());
                    enderecoEntity.setPais(endereco.getPais());
                    enderecoRepository.save(enderecoEntity);

                    return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);

                })
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
    }

    public EnderecoDTO delete (Integer id) throws Exception {
        EnderecoEntity e = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado"));
        enderecoRepository.deleteById(id);
        return objectMapper.convertValue(e, EnderecoDTO.class);
    }

}
