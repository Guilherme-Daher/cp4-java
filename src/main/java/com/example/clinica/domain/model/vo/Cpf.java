package com.example.clinica.domain.model.vo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Embeddable
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cpf {

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String value;

    public Cpf(String value) {
        this.value = value;
    }
}