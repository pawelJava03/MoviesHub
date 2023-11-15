package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.User;

import com.apapmovies.moviereviev.repositories.MovieRepository;
import com.apapmovies.moviereviev.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public RegisterController(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameError", "Username is already taken. Choose another one.");
            return "register";
        }
        userRepository.save(user);
        return "redirect:/login";
    }

}
