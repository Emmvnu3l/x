package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class chatbotController {

    // ... (Métodos existentes para selectProfile, showLoginFormAlumno, showLoginFormUsuarioPie, processLogin) ...

    // Nuevo método para mostrar la página del chatbot
    @GetMapping("/chatbot")
    public String showChatbotPage(Model model) {
        // Por ahora, simulamos que el usuario NO está autenticado para mostrar el mensaje
        // En una aplicación real, aquí verificarías el estado de autenticación del usuario.
        boolean isAuthenticated = false; // Simula que no está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);

        return "chatbot/chatbot"; // Esto buscará templates/chatbot/chatbot.html
    }
    @GetMapping("/chatbot/registered") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPage(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/chatbot-registered"; // Esta es la nueva plantilla que crearemos
    }

    @PostMapping("/process-login-demo")
    public String processLoginDemo(@RequestParam String username,
                                   @RequestParam String password,
                                   Model model) {
        // En un escenario real, aquí iría la validación de credenciales contra una base de datos.
        // Para esta demo, simplemente validamos que los campos NO estén vacíos.
        if (username != null && !username.trim().isEmpty() &&
            password != null && !password.trim().isEmpty()) {
            
            // Si hay algo escrito, simulamos un login exitoso y redirigimos al chatbot registrado
            return "redirect:/home_registrado"; 
        } else {
            // Si algún campo está vacío (aunque el 'required' de HTML debería atraparlo),
            // volvemos a la página de login con un mensaje de error.
            model.addAttribute("error", "Por favor, ingresa tu usuario y contraseña.");
            return "login/login_alumno_2"; 
        }
    }
    @GetMapping("/chatbot/registeredr2") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPager2(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/chatbotR2"; // Esta es la nueva plantilla que crearemos
    }    
    @GetMapping("/chatbot/registeredr3") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPager3(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/chatbotR3"; // Esta es la nueva plantilla que crearemos
    }    
    @GetMapping("/chatbot/registeredr4") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPager4(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/chatbotR4"; // Esta es la nueva plantilla que crearemos
    }
    @GetMapping("/chatbot/registeredr5") // Una nueva ruta para esta versión
    public String showChatbotRegisteredPager5(Model model) {
        boolean isAuthenticated = true; // Simula que SÍ está autenticado
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "chatbot/chatbotR5"; // Esta es la nueva plantilla que crearemos
    }
}

