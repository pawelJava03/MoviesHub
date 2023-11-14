package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.User;
import com.apapmovies.moviereviev.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userRepository.save(user);
        return "redirect:/login";
    }
}
