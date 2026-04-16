package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Atencion;

import java.util.List;

public interface AtencionService {
    List<Atencion> findAll();

    Atencion save(Atencion atencion);


}
