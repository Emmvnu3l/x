package com.example.demo.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder; // ¡Importante para manejar múltiples constructores o un Builder!
import lombok.Data; // Incluye @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
import lombok.NoArgsConstructor;

@Data // Esta anotación reemplaza a @Getter, @Setter, @ToString, @EqualsAndHashCode y @RequiredArgsConstructor
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos (útil para persistencia)
@Builder // ¡Muy útil para construir objetos complejos con muchos campos opcionales!
public class Usuario {

    // Identificador único (muy recomendado para entidades)
    private Long id; // Agregado: Generalmente las entidades tienen un ID

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno; // Puede ser null
    private String rut;
    private String email;
    private LocalDate fechaNacimiento;
    private String telefono; // Puede ser null
    private LocalDateTime fechaRegistro;
    private String rol; // Por ejemplo: "ALUMNO", "DOCENTE", "PSICOLOGO", "ADMIN"

    // Campo para la URL de la foto del especialista/usuario
    private String urlFoto; // <--- ¡Asegúrate de que este campo exista!

    // Campos específicos para ALUMNO
    private String curso; // Puede ser null si no es ALUMNO
    private String profesorJefe; // Puede ser null si no es ALUMNO
    private String asistencias; // Ejemplo: "95%", "00 de 00"
    private String semestreIngreso; // Ejemplo: "primer semestre 2007"

    // Campos específicos para APODERADO (si el usuario es ALUMNO)
    private String apoderadoNombre; // Puede ser null si no es ALUMNO
    private String apoderadoRut; // Puede ser null si no es ALUMNO
    private String apoderadoTelefono; // Puede ser null si no es ALUMNO
    private String apoderadoEmail; // Puede ser null si no es ALUMNO

    // Campos específicos para roles que NO son ALUMNO (ej. DOCENTE, PSICOLOGO)
    private String especialidad; // Puede ser null si es ALUMNO (usado para Especialistas)
    private String matriculaProfesional; // Puede ser null si es ALUMNO
    private Integer aniosExperiencia; // Puede ser null si es ALUMNO

    // Campo general "Acerca de mí"
    private String acercaDeMi; // Puede ser null
}