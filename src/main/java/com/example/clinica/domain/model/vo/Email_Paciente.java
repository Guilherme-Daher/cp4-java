package com.example.clinica.domain.model.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email_Paciente {

    @Email(message = "Email inválido")
    @NotBlank(message = "Email não pode estar em branco")
    @Column(name = "email", nullable = false)
    private String value;

    public Email_Paciente(String value) {
        this.value = value;
    }
}