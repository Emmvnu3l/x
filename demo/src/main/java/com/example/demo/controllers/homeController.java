package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    public class homeController {
    @GetMapping("/home")
    public String home() {
        return "/home/home";
    }
    @GetMapping("/home_registrado")
    public String homer() {
        return "home/home_registrado";
    }


    @PostMapping("/process-home")
    public String processLoginDemo(@RequestParam String username,
                                   @RequestParam String password,
                                   Model model) {
        // En un escenario real, aquí iría la validación de credenciales contra una base de datos.
        // Para esta demo, simplemente validamos que los campos NO estén vacíos.
        if (username != null && !username.trim().isEmpty() &&
            password != null && !password.trim().isEmpty()) {
            
            // Si hay algo escrito, simulamos un login exitoso y redirigimos al chatbot registrado
            return "redirect:/home"; 
        } else {
            // Si algún campo está vacío (aunque el 'required' de HTML debería atraparlo),
            // volvemos a la página de login con un mensaje de error.
            model.addAttribute("error", "Por favor, ingresa tu usuario y contraseña.");
            return "login/login_alumno2"; 
        }
    }

    
    @GetMapping("/home_pie")
    public String homePie() {
        return "home/home_pie";
    }


}  

