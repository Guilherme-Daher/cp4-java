package com.example.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoDTO {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;
}