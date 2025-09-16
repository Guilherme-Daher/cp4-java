package com.example.clinica.controller;

import com.example.clinica.domain.model.Medico;
import com.example.clinica.dto.MedicoCreateRequest;
import com.example.clinica.dto.MedicoDTO;
import com.example.clinica.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico create(@RequestBody @Valid MedicoCreateRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public Medico findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<MedicoDTO> list() {
        return service.list();
    }
}