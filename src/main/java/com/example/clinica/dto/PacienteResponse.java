package com.example.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}