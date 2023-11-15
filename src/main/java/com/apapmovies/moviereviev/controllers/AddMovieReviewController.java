package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.repositories.MovieRepository;
import com.apapmovies.moviereviev.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddMovieReviewController {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public AddMovieReviewController(MovieRepository movieRepository,
                                    UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/movie-review")
    public String movieReviewForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }



    @PostMapping("/movie-review")
    public String processAddMovieReview(@ModelAttribute("movie") @Valid Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "add_movie";
        }
        movieRepository.save(movie);
        return "redirect:/moviehub-all-reviews";
    }



}
