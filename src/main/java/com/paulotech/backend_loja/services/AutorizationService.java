package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizationService implements UserDetailsService {

    @Autowired
    UserRepositories repositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositories.findByLogin(username);
    }
}
