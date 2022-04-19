package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    private EnderecoService enderecoService;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO){

        Pessoa p = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        p = pessoaRepository.create(p);
        if (p != null){
            emailService.sendEmail(objectMapper.convertValue(p, PessoaDTO.class), "Novo Cadastro","email-template-cria-pessoa.ftl");
        }
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa p = pessoaRepository.update(id, objectMapper.convertValue(pessoaAtualizar, Pessoa.class));
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public PessoaDTO delete(Integer id) throws Exception {
        return objectMapper.convertValue(pessoaRepository.delete(id), PessoaDTO.class);
    }


    @Scheduled(cron = "0 0 8,20 * * *")
    public void enderecoNaoCadastrado(){
        boolean flag = false;
        for (PessoaDTO pessoa : list()){
            for (EnderecoDTO enderecoDTO : enderecoService.list()){
                if (enderecoDTO.getIdPessoa().equals(pessoa.getIdPessoa())) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                emailService.sendEmailEndereco(pessoa);
            } else {
                flag = false;
            }
        }
    }

    @Scheduled(cron = "@monthly")
    public void sendEmailPromocoes() {
        for (Pessoa pessoa : pessoaRepository.list()){
            emailService.sendEmailPromocao(pessoa);
        }
    }

    @Scheduled(cron = "@daily")
    public void emailAniversario() {
        for (Pessoa pessoa : pessoaRepository.list()){
            if(pessoa.getDataNascimento().equals(LocalDate.now())){
                emailService.sendEmailAniversario(pessoa);
            }
        }

    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById (Integer id) throws Exception {
       return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Pessa nao encontrada"));
    }
}
