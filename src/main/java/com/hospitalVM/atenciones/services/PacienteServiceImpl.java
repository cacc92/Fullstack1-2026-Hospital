package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.PacienteException;
import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByCorreo(String correo) {
        return this.pacienteRepository.findByCorreo(correo).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByRut(String rut) {
        return this.pacienteRepository.findByRut(rut).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }

    @Override
    public Paciente save(Paciente paciente) {
        if(this.findByCorreo(paciente.getCorreo()) != null){
            throw new PacienteException("Paciente ya existe");
        }
        if(this.findByRut(paciente.getRut()) != null){
            throw new PacienteException("Paciente ya existe");
        }
        return this.pacienteRepository.save(paciente);
    }

    @Override
    public void deleteById(Long id) {
        this.pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return this.pacienteRepository.findById(id).map(element-> {
            element.setNombres(paciente.getNombres());
            element.setApellidos(paciente.getApellidos());
            element.setFechaNacimiento(paciente.getFechaNacimiento());
            return this.pacienteRepository.save(element);
        }).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }
}
