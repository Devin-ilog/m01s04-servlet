package tech.devinhouse.m01s06spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String get() {
        return "Funcionando corretamente! \\o/";
    }

}
