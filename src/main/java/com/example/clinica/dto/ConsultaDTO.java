package com.example.clinica.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {

    @NotNull(message = "ID do paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "ID do médico é obrigatório")
    private Long medicoId;

    @NotNull(message = "Data e hora da consulta são obrigatórias")
    @Future(message = "A data da consulta deve ser no futuro")
    private LocalDateTime dataHora;
}