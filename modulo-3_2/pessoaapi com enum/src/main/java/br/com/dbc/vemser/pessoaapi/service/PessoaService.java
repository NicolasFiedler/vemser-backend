package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.*;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO){

        PessoaEntity p = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaRepository.save(p);
//        if (p != null){
//            emailService.sendEmail(objectMapper.convertValue(p, PessoaDTO.class), "Novo Cadastro","email-template-cria-pessoa.ftl");
//        }
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        return pessoaRepository.findById(id)
                        .map(pessoaEntity -> {

                            pessoaEntity.setNome(pessoaAtualizar.getNome());
                            pessoaEntity.setEmail(pessoaAtualizar.getEmail());
                            pessoaEntity.setCpf(pessoaAtualizar.getCpf());
                            pessoaEntity.setDataNascimento(pessoaAtualizar.getDataNascimento());
                            pessoaRepository.save(pessoaEntity);

                            return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

                        })
                        .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada"));
    }

    public PessoaDTO delete(Integer id) throws Exception {
        PessoaDTO pessoaDTO = getPessoaById(id);
        pessoaRepository.deleteById(id);
        return pessoaDTO;
    }

    public PessoaDTO getPessoaById (Integer id) throws Exception {
       return pessoaRepository.findById(id)
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Pessa nao encontrada"));
    }

    public List<PessoaDTO> findByNomeIgnoreCaseContaining(String nome) {
        return pessoaRepository.findByNomeIgnoreCaseContaining(nome).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO findByCpf(String cpf) throws RegraDeNegocioException {
        return pessoaRepository.findByCpf(cpf)
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .stream().findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada"));
    }

    public List<PessoaDTO> findByDataNascimentoBetween(LocalDate incicio, LocalDate fim) {
        return pessoaRepository.findByDataNascimentoBetween(incicio, fim).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTOComContatos> listComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );

                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }

    public List<PessoaDTOComEndereco> listComEndereco (Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComEndereco> pessoaDTOComEnderecoList = new ArrayList<>();
        if (idPessoa == null){
            pessoaDTOComEnderecoList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTOComEndereco pessoaDTOComEndereco = objectMapper.convertValue(pessoaEntity,PessoaDTOComEndereco.class);
                        pessoaDTOComEndereco.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );

                        return pessoaDTOComEndereco;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComEndereco pessoaDTOComEndereco = objectMapper.convertValue(pessoaEntity, PessoaDTOComEndereco.class);
            pessoaDTOComEndereco.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOComEnderecoList.add(pessoaDTOComEndereco);
        }
        return pessoaDTOComEnderecoList;
    }

    public List<PessoaDTOCompleta> listPessoaCompleta (Integer id) {
        return pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> {
                    if (id == null){
                        return true;
                    } else if (pessoaEntity.getIdPessoa().equals(id)){
                        return true;
                    }
                    return false;
                })
                .map(pessoaEntity -> {
                    PessoaDTOCompleta p = objectMapper.convertValue(pessoaEntity, PessoaDTOCompleta.class);
                    p.setContatos(pessoaEntity.getContatos().stream()
                            .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                            .collect(Collectors.toList()));
                    p.setEnderecos(pessoaEntity.getEnderecos().stream()
                            .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                            .collect(Collectors.toList()));
                    return p;
                })
                .collect(Collectors.toList());
    }
}
