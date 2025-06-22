package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
public class citasController {
    

    @GetMapping("/agendar")
    public String agendarE() {
        return "/citas/agendar_cita";
    }

    @GetMapping("/cita_confirmada")
    public String citaConfi() {
        return "/citas/cita_confirmada";
    }

    

}
