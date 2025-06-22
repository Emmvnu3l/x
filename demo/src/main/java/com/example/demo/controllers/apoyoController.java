package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class apoyoController {
    @GetMapping("/apoyo_yt")
    public String apoyoYt() {
        return "apoyo/apoyo_yt";
    }
    @GetMapping("/apoyo_guide")
    public String apoyoGd() {
        return "apoyo/apoyo_guide";
    }


}
