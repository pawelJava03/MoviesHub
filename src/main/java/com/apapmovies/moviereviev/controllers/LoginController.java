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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginFrom(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "login";
        }
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            // Błędne dane logowania
            result.rejectValue("username", "error.user", "Invalid username or password");
            return "redirect:/usernotfound";
        }

        // Przekierowanie po poprawnym uwierzytelnieniu
        redirectAttributes.addFlashAttribute("username", existingUser.getUsername());
        return "redirect:/home-site";
    }
}
