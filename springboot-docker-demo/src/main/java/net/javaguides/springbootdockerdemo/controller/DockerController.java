package net.javaguides.springbootdockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("/docker")
    public String dockerDemo(){
        return "Dockerizing SB Application";
    }
}
