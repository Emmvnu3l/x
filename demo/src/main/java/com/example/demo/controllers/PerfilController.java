package com.example.demo.controllers;

import com.example.demo.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // Importar PostMapping
import org.springframework.web.bind.annotation.RequestParam; // Importar RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // Importar RedirectAttributes

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime; // Importar LocalTime
import java.util.ArrayList;
import java.util.List;

@Controller
public class PerfilController {

    // ... (Mantén tus métodos @GetMapping("/perfil") y @GetMapping("/usuarios_pie")) ...
    @GetMapping("/perfil")
    public String mostrarPerfil(Model model) {
        // Ejemplo de un usuario ALUMNO usando el Builder de Lombok
        Usuario alumno = Usuario.builder()
                .id(1L)
                .nombre("Franco")
                .apellidoPaterno("Alaman")
                .apellidoMaterno("Soto Jonquera")
                .rut("20.320.000-K")
                .email("fsa.soto@portalpie.cl")
                .fechaNacimiento(LocalDate.of(2010, 5, 21))
                .telefono("+569 1234 5678")
                .fechaRegistro(LocalDateTime.now())
                .rol("ALUMNO")
                .curso("2° Medio A")
                .profesorJefe("Santiago I. Cabrera S.")
                .asistencias("95%")
                .semestreIngreso("Primer Semestre 2007")
                .apoderadoNombre("Josefa Valentina Jonquera Sepulveda")
                .apoderadoRut("14.150.000-9")
                .apoderadoTelefono("+569 7674 4136")
                .apoderadoEmail("jovalen@gmail.com")
                .acercaDeMi("Apasionado por la tecnología y los videojuegos. Buscando siempre aprender algo nuevo.")
                .urlFoto("/images/alumno_franco.jpg")
                .build();
        model.addAttribute("usuario", alumno);

        return "usuarios/mi_perfil_alumno";
    }

    @GetMapping("/usuarios_pie")
    public String mostrarEspecialistasPie(Model model) {
        List<Usuario> especialistas = new ArrayList<>();

        especialistas.add(Usuario.builder()
                .id(101L)
                .nombre("Anakena")
                .apellidoPaterno("Balbontin")
                .apellidoMaterno("López")
                .rut("11.222.333-4")
                .email("s.ramirez@portalpie.cl")
                .fechaNacimiento(LocalDate.of(1985, 7, 15))
                .telefono("+569 1111 2222")
                .fechaRegistro(LocalDateTime.now())
                .rol("PSICOPEDAGOGA")
                .especialidad("Psicopedagogía")
                .matriculaProfesional("PSP-001")
                .aniosExperiencia(10)
                .acercaDeMi("Especialista en dificultades de aprendizaje y estrategias de estudio. Apasionada por el desarrollo cognitivo de los niños.")
                .urlFoto("/images/woman1.jpg")
                .build());

        especialistas.add(Usuario.builder()
                .id(102L)
                .nombre("Daniel")
                .apellidoPaterno("Vidal")
                .apellidoMaterno("Díaz")
                .rut("13.444.555-6")
                .email("c.fuentes@portalpie.cl")
                .fechaNacimiento(LocalDate.of(1978, 11, 3))
                .telefono("+569 3333 4444")
                .fechaRegistro(LocalDateTime.now())
                .rol("PSICOLOGO")
                .especialidad("Psicología Educacional")
                .matriculaProfesional("PSI-002")
                .aniosExperiencia(18)
                .acercaDeMi("Psicólogo clínico con enfoque en apoyo emocional y conductual para adolescentes. Promotor de la salud mental en el ámbito escolar.")
                .urlFoto("/images/daniel.png")
                .build());

        especialistas.add(Usuario.builder()
                .id(103L)
                .nombre("Emmanuel")
                .apellidoPaterno("Moreno")
                .apellidoMaterno("Vargas")
                .rut("15.666.777-8")
                .email("l.mendoza@portalpie.cl")
                .fechaNacimiento(LocalDate.of(1990, 1, 20))
                .telefono("+569 5555 6666")
                .fechaRegistro(LocalDateTime.now())
                .rol("FONOAUDIOLOGO")
                .especialidad("Fonoaudiología Clínica")
                .matriculaProfesional("FONO-003")
                .aniosExperiencia(7)
                .acercaDeMi("Experta en trastornos del lenguaje y comunicación. Ayudo a los niños a desarrollar sus habilidades lingüísticas.")
                .urlFoto("/images/ema.png")
                .build());

        model.addAttribute("especialistas", especialistas);

        return "usuarios/usuarios_pie";
    }

    @GetMapping("/perfil/{id}")
    public String verPerfilEspecialista(@PathVariable Long id, Model model) {
        Usuario especialista = Usuario.builder()
                .id(id)
                .nombre("Especialista Demo")
                .apellidoPaterno("Apellido")
                .especialidad("Especialidad " + id)
                .acercaDeMi("Este es un perfil de demostración para el especialista con ID: " + id + ". Aquí se mostraría toda su información detallada.")
                .urlFoto("/images/avatar_default.webp")
                .build();

        model.addAttribute("especialista", especialista);
        return "usuarios/perfil_individual_especialista";
    }

    @GetMapping("/contactar/{id}")
    public String contactarEspecialista(@PathVariable Long id, Model model) {
        model.addAttribute("especialistaId", id);
        return "usuarios/contactar_especialista";
    }

    @GetMapping("/agendar/{id}")
    public String agendarCita(@PathVariable Long id, Model model) {
        model.addAttribute("especialistaId", id);
        // Puedes pasar datos del especialista si los necesitas en la vista de agendar
        // Usuario especialista = servicio.findEspecialistaById(id);
        // model.addAttribute("especialista", especialista);
        return "usuarios/agendar_cita_especialista";
    }

    // Método para manejar el envío del formulario de agendamiento
    @PostMapping("/confirmar_cita/{especialistaId}")
    public String confirmarCita(
            @PathVariable Long especialistaId,
            @RequestParam("fecha") LocalDate fecha, // Asegúrate que el name del input coincida
            @RequestParam("hora") LocalTime hora,   // Asegúrate que el name del input coincida
            @RequestParam(value = "motivo", required = false) String motivo, // motivo es opcional
            RedirectAttributes redirectAttributes,
            Model model) { // Añadir Model para pasar atributos si no se redirige completamente

        // *** Lógica para "registrar" la cita ***
        // Aquí es donde en una aplicación real guardarías la cita en una base de datos,
        // validarías la disponibilidad del especialista, enviarías notificaciones, etc.
        System.out.println("Cita agendada para especialista ID: " + especialistaId +
                           " el " + fecha + " a las " + hora +
                           (motivo != null && !motivo.isEmpty() ? " - Motivo: " + motivo : ""));

        // Puedes agregar atributos al RedirectAttributes si quieres pasarlos a la página de confirmación
        // Opcional: pasar los datos de la cita a la página de confirmación
        redirectAttributes.addFlashAttribute("especialistaId", especialistaId);
        redirectAttributes.addFlashAttribute("fechaCita", fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        redirectAttributes.addFlashAttribute("horaCita", hora.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
        redirectAttributes.addFlashAttribute("motivoCita", motivo);

        // Redirige a la nueva página de confirmación
        return "redirect:/cita_registrada"; // REDIRECCIÓN A LA NUEVA PÁGINA
    }

    // Nuevo método para mostrar la página de confirmación
    @GetMapping("/cita_registrada")
    public String mostrarConfirmacionCita(Model model) {
        // Los atributos pasados con redirectAttributes.addFlashAttribute
        // estarán automáticamente disponibles en el modelo de esta vista.
        // No necesitas volver a agregarlos aquí.
        return "usuarios/cita_confirmada"; // Nombre del nuevo archivo HTML
    }

    @PostMapping("/enviar_mensaje/{especialistaId}")
    public String enviarMensaje(@PathVariable Long especialistaId,
                                 @RequestParam String nombre,
                                 @RequestParam String email,
                                 @RequestParam String asunto,
                                 @RequestParam String mensaje,
                                 RedirectAttributes redirectAttributes) {
        System.out.println("Mensaje para especialista " + especialistaId + " de " + nombre + " (" + email + "): " + asunto + " - " + mensaje);
        redirectAttributes.addFlashAttribute("successMessage", "Tu mensaje ha sido enviado.");
        return "redirect:/perfil/" + especialistaId;
    }

    @GetMapping("/perfil/101")
    public String showProfessionalProfile1() {
        return "usuarios/perfil_101";
    }
    @GetMapping("/perfil/102")
    public String showProfessionalProfile2() {
        return "usuarios/perfil_102";
    }
    @GetMapping("/perfil/103")
    public String showProfessionalProfile3() {
        return "usuarios/perfil_103";
    }
}