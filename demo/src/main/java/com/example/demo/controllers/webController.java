package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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


    // Método para mostrar la lista de especialistas (si tienes un enlace a esta página)
    @GetMapping("/lista-especialistas-demo")
    public String showSpecialistsList(Model model) {
        // En una aplicación real, aquí cargarías una lista de especialistas desde tu servicio/BD.
        // Para la demo, el HTML ya tiene 3 tarjetas hardcodeadas.
        return "especialistas/lista_especialistas"; // Ruta a tu archivo lista_especialistas.html
    }

    
}
