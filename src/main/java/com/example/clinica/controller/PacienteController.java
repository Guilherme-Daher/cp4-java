package com.example.clinica.controller;

import com.example.clinica.dto.PacienteCreateRequest;
import com.example.clinica.dto.PacienteResponse;
import com.example.clinica.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponse create(@RequestBody @Valid PacienteCreateRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public PacienteResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PacienteResponse> list() {
        return service.list();
    }
}