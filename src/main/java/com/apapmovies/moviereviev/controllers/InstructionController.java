package com.apapmovies.moviereviev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructionController {
    @GetMapping("/instruction")
    public String instructionForm(){
        return "instruction";
    }
}
