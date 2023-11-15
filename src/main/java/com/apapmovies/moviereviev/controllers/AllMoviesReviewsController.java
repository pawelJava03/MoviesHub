package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.repositories.MovieRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class AllMoviesReviewsController {

    private final MovieRepository movieRepository;

    public AllMoviesReviewsController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @GetMapping("/moviehub-all-reviews")
    public String showAllMovieReviews(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            model.addAttribute("welcomeMessage", "Hi, " + username + ". Welcome at MovieHub");
            List<Movie> movieReviews = movieRepository.findAll();
            model.addAttribute("movieReviews", movieReviews);
            return "all-movie-reviews";
        }
        return "/session_error";
    }
}
