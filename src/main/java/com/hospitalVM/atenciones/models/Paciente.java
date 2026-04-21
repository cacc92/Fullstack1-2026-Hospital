package com.hospitalVM.atenciones.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;

    @NotBlank(message = "El campo de rut no puede ser vacio")
    @Pattern(regexp = "^\\d{7,8}-[\\dkK]$", message = "El formato del run debe ser xxxxxxxx-x")
    @Column(nullable = false, unique = true)
    private String rut;

    @NotBlank(message = "El campo de nombres no puede ser vacio")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El campo de apellidos no puede ser vacio")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El campo de fecha de nacimiento no puede ser vacio")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El campo de correo no puede ser vacio")
    @Email(message = "El campo de correo tiene que tener el formato de correo")
    @Column(nullable = false, unique = true)
    private String correo;

    @Embedded
    Audit audit = new Audit();
}
