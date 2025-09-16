package com.example.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class PacienteCreateRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}