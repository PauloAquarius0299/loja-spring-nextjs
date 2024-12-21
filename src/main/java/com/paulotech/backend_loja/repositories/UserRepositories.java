package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepositories extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
