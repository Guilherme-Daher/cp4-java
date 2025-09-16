package com.example.clinica.domain.model;

import com.example.clinica.domain.model.vo.Email_Paciente;
import com.example.clinica.domain.model.vo.Email_Paciente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crm;
    private String especialidade;

    @Embedded
    private Email_Paciente email;
}