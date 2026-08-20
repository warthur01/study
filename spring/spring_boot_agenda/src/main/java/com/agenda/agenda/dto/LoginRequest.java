package com.agenda.agenda.dto;

public record LoginRequest(
        String username,
        String password
) {
}