package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.AtencionException;
import com.hospitalVM.atenciones.exceptions.MedicoInexistenteException;
import com.hospitalVM.atenciones.exceptions.PacienteException;
import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.models.dtos.AtencionCreacionDTO;
import com.hospitalVM.atenciones.repositories.AtencionRepository;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Atencion> findAll() {
        return this.atencionRepository.findAll();
    }

    @Override
    public Atencion findById(Long id) {
        return this.atencionRepository.findById(id).orElseThrow(
                () -> new AtencionException("Atencion no encontrado")
        );
    }

    @Override
    public Atencion save(AtencionCreacionDTO atencion) {
        Medico medico = this.medicoRepository.findById(atencion.getMedicoId()).orElseThrow(
                () -> new MedicoInexistenteException("Medico no encontrado")
        );
        Paciente paciente = this.pacienteRepository.findById(atencion.getPacienteId()).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
        Atencion atencionEntity = new Atencion();
        atencionEntity.setMedico(medico);
        atencionEntity.setPaciente(paciente);
        atencionEntity.setHoraAtencion(atencion.getHoraAtencion());
        atencionEntity.setCosto(atencion.getCosto());
        atencionEntity.setComentario(atencion.getComentario());
        return  this.atencionRepository.save(atencionEntity);
    }
}
