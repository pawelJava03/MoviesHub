package com.apapmovies.moviereviev.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionErrorController {
    @GetMapping("/sessionerror")
    public String sessionErrorForm(){
        return "session_error";
    }
}
