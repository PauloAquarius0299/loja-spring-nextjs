package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.dto.AuthenticationDTO;
import com.paulotech.backend_loja.dto.LoginResponseDTO;
import com.paulotech.backend_loja.dto.RegisterDTO;
import com.paulotech.backend_loja.entity.User;
import com.paulotech.backend_loja.infra.security.TokenService;
import com.paulotech.backend_loja.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepositories repositories;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if(this.repositories.findByLogin(data.login()) != null)
        return ResponseEntity.badRequest().build();

        String oncryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), oncryptedPassword, data.role());

        this.repositories.save(newUser);

        return ResponseEntity.ok().build();
    }
}
