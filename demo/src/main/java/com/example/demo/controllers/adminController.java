package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class adminController {
    @GetMapping("/home_admin") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPage(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/"; // Esta es la nueva plantilla que crearemos
    }
}
