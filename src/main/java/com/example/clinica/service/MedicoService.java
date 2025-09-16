package com.example.clinica.service;

import com.example.clinica.domain.model.Medico;
import com.example.clinica.domain.model.vo.Email_Paciente;
import com.example.clinica.dto.MedicoCreateRequest;
import com.example.clinica.dto.MedicoDTO;
import com.example.clinica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public Medico create(MedicoCreateRequest request) {
        Medico medico = new Medico();
        medico.setNome(request.getNome());
        medico.setCrm(request.getCrm());
        medico.setEspecialidade(request.getEspecialidade());
        medico.setEmail(new Email_Paciente(request.getEmail())); // corrigido aqui
        return repository.save(medico);
    }

    public Medico findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public List<MedicoDTO> list() {
        return repository.findAll().stream()
                .map(m -> new MedicoDTO(
                        m.getId(),
                        m.getNome(),
                        m.getCrm(),
                        m.getEspecialidade(),
                        m.getEmail().getValue())) // corrigido aqui também
                .collect(Collectors.toList());
    }
}