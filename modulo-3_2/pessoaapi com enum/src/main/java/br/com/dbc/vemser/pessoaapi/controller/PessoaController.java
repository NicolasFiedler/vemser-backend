package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.contato.PessoaDTOComEndereco;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTOComContatos;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@Log
@RequiredArgsConstructor
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final PropertieReader propertieReader;
    private final EmailService emailService;

    @ApiOperation(value = "Hello World!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a mensagem 'Hello world!'")
    })
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @ApiOperation(value = "Insere e retorna a pessoa inserida")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa inserida"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping // localhost:8080/pessoa
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        log.info("Pessoa Inserida");
        return pessoaService.create(pessoa);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("Request de pessoas");
        return pessoaService.list();
    }

    @ApiOperation(value = "Retorna a pessoa encontrada pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public PessoaDTO getById(@Valid @PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Pessoa por ID");
        return pessoaService.getPessoaById(id);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas com este nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna as pessoas encontradas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        log.info("Request de pessoa por nome");
        return pessoaService.findByNomeIgnoreCaseContaining(nome);
    }

    @ApiOperation(value = "Retorna a pessoas com este cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/bycpf")
    public PessoaDTO listByCpf(@RequestParam("cpf") String cpf) throws RegraDeNegocioException {
        log.info("Request de pessoa por cpf");
        return pessoaService.findByCpf(cpf);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas com este nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna as pessoas encontradas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
//    @GetMapping("/bydate")
//    public List<PessoaDTO> findByDataNascimentoBetween(@RequestParam("incio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
//                                                       @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fim) {
//        return pessoaService.findByDataNascimentoBetween(inicio, fim);
//    }

    @GetMapping("/bydate")
    public List<PessoaEntity> findByBetweenDataNascimento(@RequestParam("incio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                                                          @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fim) {
        return pessoaRepository.findByBetweenDataNascimentoJPQL(inicio, fim);
    }

    @GetMapping("/listar-pessoas-com-endereco")
    public List<PessoaEntity> pessoasComEndereco() {
        return pessoaRepository.pessoasComEndereco();
    }

    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listarPessoasComContato(@RequestParam(value = "id", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listComContatos(idPessoa);
    }

    @GetMapping("/listar-com-enderecos")
    public List<PessoaDTOComEndereco> listarPessoasComEndereco(@RequestParam(value = "id", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listComEndereco(idPessoa);
    }

    @GetMapping("/listar-sem-enderecos")
    public List<PessoaEntity> pessoaSemEndereco(){
        return pessoaRepository.pessoaSemEndereco();
    }

    @ApiOperation(value = "Altera e retorna a pessoa alterada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa alterada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@Valid @PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Pessoa Atualizada");
        return pessoaService.update(id, pessoaAtualizar);
    }

    @ApiOperation(value = "Remove e retorna a pessoa removida")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa removida"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public PessoaDTO delete(@Valid @PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Pessoa Removida");
        return pessoaService.delete(id);
    }

//    @GetMapping("/ambiente")
//    public String getAmbiente () {
//        return propertieReader.getAmbiente();
//    }
}
