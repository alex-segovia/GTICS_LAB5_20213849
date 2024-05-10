package com.example.laboratorio5.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private Integer id;

    @NotBlank(message = "Debes ingresar un nombre")
    @Size(min = 3,max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @NotBlank(message = "Debes ingresar un apellido")
    @Size(min = 3,max = 100, message = "El apellido debe tener entre 3 y 100 caracteres")
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "Debes ingresar un DNI")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    @Digits(integer = 8, fraction = 0, message = "El DNI debe ser un número entero")
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @NotBlank(message = "Debes ingresar un teléfono")
    @Size(min = 9,max = 9, message = "El teléfono debe tener 9 dígitos")
    @Digits(integer = 9, fraction = 0, message = "El DNI debe ser un número entero")
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;

    @NotNull(message = "Debes ingresar una edad")
    @Positive(message = "La edad debe ser un número positivo")
    @Column(name = "Age", nullable = false)
    private Integer age;

}
