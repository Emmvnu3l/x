package com.example.demo.entities;
    import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno; // Puede ser null
    private String rut;
    private String email;
    private LocalDate fechaNacimiento;
    private String telefono; // Puede ser null
    private LocalDateTime fechaRegistro;
    private String rol; // Por ejemplo: "ALUMNO", "DOCENTE", "PSICOLOGO", "ADMIN"

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
    private String especialidad; // Puede ser null si es ALUMNO
    private String matriculaProfesional; // Puede ser null si es ALUMNO
    private Integer aniosExperiencia; // Puede ser null si es ALUMNO

    // Campo general "Acerca de mí"
    private String acercaDeMi; // Puede ser null

    // Constructor (puedes tener varios, o usar un builder)
    // Constructor completo de ejemplo para un Alumno:
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String email, LocalDate fechaNacimiento, String telefono, LocalDateTime fechaRegistro, String rol, String curso, String profesorJefe, String asistencias, String semestreIngreso, String apoderadoNombre, String apoderadoRut, String apoderadoTelefono, String apoderadoEmail, String acercaDeMi) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.curso = curso;
        this.profesorJefe = profesorJefe;
        this.asistencias = asistencias;
        this.semestreIngreso = semestreIngreso;
        this.apoderadoNombre = apoderadoNombre;
        this.apoderadoRut = apoderadoRut;
        this.apoderadoTelefono = apoderadoTelefono;
        this.apoderadoEmail = apoderadoEmail;
        this.acercaDeMi = acercaDeMi;
    }

    // Constructor de ejemplo para un Docente/Profesional:
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String email, LocalDate fechaNacimiento, String telefono, LocalDateTime fechaRegistro, String rol, String especialidad, String matriculaProfesional, Integer aniosExperiencia, String acercaDeMi) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.especialidad = especialidad;
        this.matriculaProfesional = matriculaProfesional;
        this.aniosExperiencia = aniosExperiencia;
        this.acercaDeMi = acercaDeMi;
    }

    // Constructor básico (o para otros roles sin datos específicos)
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String email, LocalDate fechaNacimiento, String telefono, LocalDateTime fechaRegistro, String rol, String acercaDeMi) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.acercaDeMi = acercaDeMi;
    }


    // Getters y Setters (GENERAR TODOS los getters, solo los setters si vas a modificar el objeto)
    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public String getRut() { return rut; }
    public String getEmail() { return email; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getTelefono() { return telefono; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public String getRol() { return rol; }
    public String getCurso() { return curso; }
    public String getProfesorJefe() { return profesorJefe; }
    public String getAsistencias() { return asistencias; }
    public String getSemestreIngreso() { return semestreIngreso; }
    public String getApoderadoNombre() { return apoderadoNombre; }
    public String getApoderadoRut() { return apoderadoRut; }
    public String getApoderadoTelefono() { return apoderadoTelefono; }
    public String getApoderadoEmail() { return apoderadoEmail; }
    public String getEspecialidad() { return especialidad; }
    public String getMatriculaProfesional() { return matriculaProfesional; }
    public Integer getAniosExperiencia() { return aniosExperiencia; }
    public String getAcercaDeMi() { return acercaDeMi; }

    // Puedes agregar setters si necesitas modificar el objeto Usuario en el controlador antes de pasarlo a la vista.
}

