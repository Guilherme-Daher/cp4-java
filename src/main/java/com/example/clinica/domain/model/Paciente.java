package com.example.clinica.domain.model;

import com.example.clinica.domain.model.vo.Cpf;
import com.example.clinica.domain.model.vo.Email_Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Cpf cpf;

    @Embedded
    private Email_Paciente email;

    private String telefone;
}