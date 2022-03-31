package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String BEARER = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String getToken(UsuarioEntity usuarioEntity){

    }

    public Authentication isValid(HttpServletRequest request) {
        String authorizatioToken = request.getHeader(HEADER_AUTHORIZATION);

        if (authorizatioToken != null){
            String user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(authorizatioToken.replace(BEARER, ""))
                    .getBody()
                    .getSubject()
                    //TODO - seguir daqui

        }
    }
}
