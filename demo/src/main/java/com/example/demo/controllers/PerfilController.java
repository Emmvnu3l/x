package com.example.demo.controllers;

import com.example.demo.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Importar para @PathVariable
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String mostrarPerfil(Model model) {
        // Ejemplo de un usuario ALUMNO usando el Builder de Lombok
        Usuario alumno = Usuario.builder()
                .id(1L) // Es una buena práctica asignarle un ID
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
                .urlFoto("/images/alumno_franco.jpg") // Agrega una URL de foto para el alumno
                .build();
        model.addAttribute("usuario", alumno);

        return "usuarios/mi_perfil_alumno";
    }

    @GetMapping("/usuarios_pie") // La URL para acceder a esta página
    public String mostrarEspecialistasPie(Model model) {
        List<Usuario> especialistas = new ArrayList<>();

        // Ejemplo de datos de especialistas usando el Builder de Lombok
        especialistas.add(Usuario.builder()
                .id(101L) // ID único para cada especialista
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
                .urlFoto("/images/anakena_balbontin.jpg") // Ruta de la imagen
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
                .urlFoto("/images/daniel_vidal.png") // Ruta de la imagen
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
                .urlFoto("/images/emmanuel_moreno.jpeg") // Ruta de la imagen
                .build());

        // Puedes añadir más especialistas aquí...

        model.addAttribute("especialistas", especialistas); // Pasa la lista al modelo

        return "usuarios/usuarios_pie"; // Nombre del archivo HTML de esta vista
    }

    // --- Nuevos Endpoints para los botones de acción ---

    // Este método simula la vista de perfil individual de un especialista
    @GetMapping("/perfil/{id}")
    public String verPerfilEspecialista(@PathVariable Long id, Model model) {
        // En un caso real, buscarías el especialista por ID en una base de datos
        // Por ahora, crearemos un especialista de ejemplo para el ID
        Usuario especialista = Usuario.builder()
                .id(id)
                .nombre("Especialista Demo")
                .apellidoPaterno("Apellido")
                .especialidad("Especialidad " + id)
                .acercaDeMi("Este es un perfil de demostración para el especialista con ID: " + id + ". Aquí se mostraría toda su información detallada.")
                .urlFoto("/images/avatar_default.webp") // Usa una imagen por defecto o la real
                .build();

        model.addAttribute("especialista", especialista);
        return "usuarios/perfil_individual_especialista"; // Asegúrate de tener esta plantilla HTML
    }

    @GetMapping("/contactar/{id}")
    public String contactarEspecialista(@PathVariable Long id, Model model) {
        // Lógica para el formulario de contacto o redirigir a un sistema de chat
        model.addAttribute("especialistaId", id);
        return "usuarios/contactar_especialista"; // Asegúrate de tener esta plantilla HTML
    }

    @GetMapping("/agendar/{id}")
    public String agendarCita(@PathVariable Long id, Model model) {
        // Lógica para mostrar un calendario o formulario de agendamiento
        model.addAttribute("especialistaId", id);
        return "usuarios/agendar_cita_especialista"; // Asegúrate de tener esta plantilla HTML
    }

    // El endpoint /perfil_1 original, si aún lo necesitas por compatibilidad
    @GetMapping("/perfil_1")
    public String showProfessionalProfile() {
        return "usuarios/perfil_usuario_uno"; // Asumo que esta vista aún es necesaria
    }
}