package com.hospitalVM.atenciones.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo run no puede ser vacio")
    @Pattern(regexp = "^\\d{7,8}-[\\dkK]$", message = "El formato del run debe ser xxxxxxxx-x")
    private String run;

    @Column(name = "nombre_completo", nullable = false)
    @NotBlank(message = "El campo nombre completo no puede ser vacio")
    private String nombreCompleto;

    @Column(name="jefe_turno", nullable = false)
    private Boolean jefeTurno;

    @Embedded
    private Audit audit =  new Audit();

    @JsonIgnore
    @JsonManagedReference("medico-atencion")
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atencion> atenciones = new ArrayList<>();
}
