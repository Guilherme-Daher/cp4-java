package com.example.clinica.service;

import com.example.clinica.domain.model.Paciente;
import com.example.clinica.domain.model.vo.Cpf;
import com.example.clinica.domain.model.vo.Email_Paciente;
import com.example.clinica.dto.PacienteCreateRequest;
import com.example.clinica.dto.PacienteResponse;
import com.example.clinica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteResponse create(PacienteCreateRequest request) {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(new Cpf(request.getCpf()));
        paciente.setEmail(new Email_Paciente(request.getEmail()));
        paciente.setTelefone(request.getTelefone());

        Paciente saved = repository.save(paciente);

        return new PacienteResponse(
                saved.getId(),
                saved.getNome(),
                saved.getCpf().getValue(),
                saved.getEmail().getValue(),
                saved.getTelefone()
        );
    }

    public PacienteResponse findById(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return new PacienteResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf().getValue(),
                paciente.getEmail().getValue(),
                paciente.getTelefone()
        );
    }

    public List<PacienteResponse> list() {
        return repository.findAll().stream()
                .map(p -> new PacienteResponse(
                        p.getId(),
                        p.getNome(),
                        p.getCpf().getValue(),
                        p.getEmail().getValue(),
                        p.getTelefone()))
                .collect(Collectors.toList());
    }
}