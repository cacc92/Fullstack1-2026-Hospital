package com.hospitalVM.atenciones.repositories;

import com.hospitalVM.atenciones.models.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtenciónRepository extends JpaRepository<Atencion, Long> {

}
