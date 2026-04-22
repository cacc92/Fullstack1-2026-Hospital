package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.AtencionException;
import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.repositories.AtenciónRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtenciónRepository atencionRepository;

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
    public Atencion save(Atencion atencion) {
        return  this.atencionRepository.save(atencion);
    }
}
