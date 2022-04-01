package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.login.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.GrupoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoService grupoService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin (String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO register(LoginDTO loginDTO, Integer[] ids) throws RegraDeNegocioException {
        Optional<UsuarioEntity> exists = usuarioRepository.findByLogin(loginDTO.getLogin());

        if (exists.isPresent()) {
            throw new RegraDeNegocioException("Login invalido!");
        }

        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuarioEntity.getPassword()));

        Set<GrupoEntity> grupos = new HashSet<>();

        for (Integer id : ids) {
            GrupoEntity grupo = grupoService.findById(id);
            grupos.add(grupo);
        }

        usuarioEntity.setGrupos(grupos);

        usuarioRepository.save(usuarioEntity);

        return loginDTO;
    }
}
