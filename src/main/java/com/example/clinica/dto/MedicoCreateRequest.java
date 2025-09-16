package com.example.clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoCreateRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotBlank
    private String especialidade;

    @Email(message = "Email inválido")
    @NotBlank
    private String email;
}