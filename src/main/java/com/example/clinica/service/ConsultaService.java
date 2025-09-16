package com.example.clinica.service;

import com.example.clinica.domain.model.Consulta;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.domain.model.Paciente;
import com.example.clinica.domain.model.StatusConsulta;
import com.example.clinica.dto.ConsultaDTO;
import com.example.clinica.repository.ConsultaRepository;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public Consulta agendar(ConsultaDTO dto) {
        if (consultaRepository.existsByMedicoIdAndDataHora(dto.getMedicoId(), dto.getDataHora())) {
            throw new RuntimeException("O médico já possui uma consulta nesse horário.");
        }

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dto.getDataHora());
        consulta.setStatus(StatusConsulta.AGENDADA);

        return consultaRepository.save(consulta);
    }

    public Page<Consulta> listarPorMedico(Long medicoId, Pageable pageable) {
        return consultaRepository.findByMedicoId(medicoId, pageable);
    }
}