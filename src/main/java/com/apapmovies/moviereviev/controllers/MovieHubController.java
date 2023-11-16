package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.models.User;
import com.apapmovies.moviereviev.repositories.MovieRepository;
import com.apapmovies.moviereviev.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieHubController {

    private final MovieRepository movieRepository;
    public MovieHubController(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @GetMapping("/moviehub")
    public String movieHub(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            model.addAttribute("welcomeMessage", "Hi, " + username+". Welcome at MovieHub");
            return "moviehub";
        } else {
            return "redirect:/login";
        }
    }


    @GetMapping("/moviehub/users-reviews")
    public String returnMoviesListByNickname(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        User user = userRepository.findByUsername(username);
        String nickname = user.getNickname();
        List<Movie> allByNickname = movieRepository.findAllByAddedby(nickname);
        if (allByNickname.size() > 0) {
            model.addAttribute("allByNickname", allByNickname);
            return "users_reviews";
        }else return "empty_user_reviews";
    }

}
