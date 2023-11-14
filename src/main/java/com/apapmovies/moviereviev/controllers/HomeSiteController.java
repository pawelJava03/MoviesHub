package com.apapmovies.moviereviev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeSiteController {
    @GetMapping("/home-site")
    public String siteForm(){
        return "home_site";
    }
}
