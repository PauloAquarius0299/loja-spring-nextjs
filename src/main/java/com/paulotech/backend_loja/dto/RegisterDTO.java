package com.paulotech.backend_loja.dto;

import com.paulotech.backend_loja.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
