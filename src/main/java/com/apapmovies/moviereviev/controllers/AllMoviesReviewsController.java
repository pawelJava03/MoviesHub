package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.repositories.MovieRepository;
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

    @GetMapping("/moviehub")
    public String movieHubForm(){
        return "moviehub";
    }
    @GetMapping("/moviehub-all-reviews")
    public String showAllMovieReviews(Model model) {
        List<Movie> movieReviews = movieRepository.findAll();

        model.addAttribute("movieReviews", movieReviews);
        return "all-movie-reviews";
    }
}
