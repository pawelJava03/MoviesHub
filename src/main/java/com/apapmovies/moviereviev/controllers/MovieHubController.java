package com.apapmovies.moviereviev.controllers;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieHubController {

    public final MovieRepository movieRepository;

    public MovieHubController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


}
