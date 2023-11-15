package com.apapmovies.moviereviev.repositories;

import com.apapmovies.moviereviev.models.Movie;
import com.apapmovies.moviereviev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
