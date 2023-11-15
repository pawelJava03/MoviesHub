package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.User;
import com.apapmovies.moviereviev.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null && existingUser.getPassword().equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            return "redirect:/moviehub";
        } else {

            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

}
