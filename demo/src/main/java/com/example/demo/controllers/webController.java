package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Usuario;

@Controller
public class webController {
    @GetMapping("/recursos")
    public String recursos() {
        return "recursos_apoyo";
    }
    @GetMapping("/agenda")
    public String agenda() {
        return "agenda";
    }    
    @GetMapping("/preguntas_frecuentes")
    public String pFrecuentes() {
        return "preguntas_frecuentes";
    }   

    // PIE

    @GetMapping("/recursos_pie")
    public String recursosPie() {
        return "recursos_apoyo_pie";
    }
    @GetMapping("/agenda_pie")
    public String agendaPie() {
        return "agenda_pie";
    }    
    @GetMapping("/preguntas_frecuentes_pie")
    public String pFrecuentesPie() {
        return "preguntas_frecuentes_pie";
    }
 @GetMapping("/usuarios_pie") // La URL para acceder a esta página
    public String mostrarEspecialistasPie(Model model) {
        List<Usuario> especialistas = new ArrayList<>();

        // Ejemplo de datos de especialistas (crea tantos como necesites)
        // Usaremos el constructor para Docentes/Profesionales que ya tienes en Usuario
        especialistas.add(new Usuario(
            "Anakena", "Balbontin", "López", "11.222.333-4", "s.ramirez@portalpie.cl",
            LocalDate.of(1985, 7, 15), "+569 1111 2222", LocalDateTime.now(), "PSICOPEDAGOGA",
            "Psicopedagogía", "PSP-001", 10,
            "Especialista en dificultades de aprendizaje y estrategias de estudio. Apasionada por el desarrollo cognitivo de los niños."
        ));

        especialistas.add(new Usuario(
            "Daniel", "Vidal", "Díaz", "13.444.555-6", "c.fuentes@portalpie.cl",
            LocalDate.of(1978, 11, 3), "+569 3333 4444", LocalDateTime.now(), "PSICOLOGO",
            "Psicología Educacional", "PSI-002", 18,
            "Psicólogo clínico con enfoque en apoyo emocional y conductual para adolescentes. Promotor de la salud mental en el ámbito escolar."
        ));

        especialistas.add(new Usuario(
            "Emmanuel", "Moreno", "Vargas", "15.666.777-8", "l.mendoza@portalpie.cl",
            LocalDate.of(1990, 1, 20), "+569 5555 6666", LocalDateTime.now(), "FONOAUDIOLOGO",
            "Fonoaudiología Clínica", "FONO-003", 7,
            "Experta en trastornos del lenguaje y comunicación. Ayudo a los niños a desarrollar sus habilidades lingüísticas."
        ));

        // Puedes añadir más especialistas aquí...
        // especialistas.add(new Usuario(...));

        model.addAttribute("especialistas", especialistas); // Pasa la lista al modelo

        return "usuarios/mi_perfil_pie"; // Nombre del archivo HTML de esta vista
    }
    @GetMapping("/perfil_pie")
    public String perfilPie() {
        return "usuarios/mi_perfil_pie";
    }  

    @GetMapping("/especialista_demo")
    public String viewSpecialistProfile(@PathVariable Long id, Model model) {
        // Lógica para buscar el especialista por su ID
        // Ejemplo:
        // Especialista especialista = especialistaService.findById(id);
        // if (especialista == null) {
        //     // Manejar caso donde el especialista no existe, quizás redirigir a una página de error o lista
        //     return "redirect:/error";
        // }
        // model.addAttribute("especialista", especialista); // Añadir el objeto especialista al modelo

        // Aquí podrías cargar datos relacionados con el perfil que hemos estado construyendo
        // Por ejemplo, si el 'usuario' de tu perfil_usuario_uno.html es el 'especialista' en este contexto
        // Usuario usuario = usuarioService.findById(id);
        // model.addAttribute("usuario", usuario);

        return "usuario/perfil_1"; // O el nombre de tu plantilla Thymeleaf para el perfil del especialista
    }
    
}
