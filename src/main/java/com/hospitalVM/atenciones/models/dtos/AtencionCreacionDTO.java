package com.hospitalVM.atenciones.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AtencionCreacionDTO {

    @NotNull(message = "El campo hora atencion no puede ser nulo")
    private LocalDateTime horaAtencion;

    @NotNull(message = "El campo de costo no puede ser vacio")
    private Double costo;

    private String comentario;

    @NotNull(message = "El campo medico no puede ser vacio")
    private Long medicoId;

    @NotNull(message = "El campo paciente no puede ser vacio")
    private Long pacienteId;
}
