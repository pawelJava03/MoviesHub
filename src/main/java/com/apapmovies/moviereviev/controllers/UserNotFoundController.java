package com.apapmovies.moviereviev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserNotFoundController {
    @GetMapping("/usernotfound")
    public String userNotFoundForm(){
        return "user_not_found";
    }
}
