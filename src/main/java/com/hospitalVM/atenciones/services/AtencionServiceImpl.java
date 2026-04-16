package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.repositories.AtencionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtencionRespository atencionRespository;

    @Override
    public List<Atencion> findAll() {
        return List.of();
    }

    @Override
    public Atencion save(Atencion atencion) {
        return null;
    }
}
