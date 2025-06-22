package com.example.demo.controllers;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import java.time.LocalDate;
    import java.time.LocalDateTime;

import com.example.demo.entities.Usuario;
@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String mostrarPerfil(Model model) {
        // Ejemplo de un usuario ALUMNO
        Usuario alumno = new Usuario(
            "Franco", "Alaman", "Soto Jonquera", "20.320.000-K", "fsa.soto@portalpie.cl",
            LocalDate.of(2010, 5, 21), "+569 1234 5678", LocalDateTime.now(), "ALUMNO",
            "2° Medio A", "Santiago I. Cabrera S.", "95%", "Primer Semestre 2007",
            "Josefa Valentina Jonquera Sepulveda", "14.150.000-9", "+569 7674 4136", "jovalen@gmail.com",
            "Apasionado por la tecnología y los videojuegos. Buscando siempre aprender algo nuevo."
        );
        model.addAttribute("usuario", alumno); // Añadir el objeto usuario al modelo

        // Si quisieras probar con un usuario DOCENTE, por ejemplo:
        /*
        Usuario docente = new Usuario(
            "María", "González", "Pérez", "12.345.678-9", "m.gonzalez@portalpie.cl",
            LocalDate.of(1980, 3, 10), "+569 9876 5432", LocalDateTime.now(), "DOCENTE",
            "Lenguaje y Comunicación", "123456D", 15,
            "Me encanta enseñar y ver el progreso de mis estudiantes."
        );
        model.addAttribute("usuario", docente);
        */

        return "usuarios/mi_perfil_alumno"; // Nombre del archivo HTML de esta vista (perfil.html)
    }


    @GetMapping("/perfil_1")
    public String showProfessionalProfile() {
        return "usuarios/perfil_usuario_uno"; // This refers to src/main/resources/templates/profesional_profile.html
    }

}


