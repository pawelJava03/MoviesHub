package com.apapmovies.moviereviev.repositories;

import com.apapmovies.moviereviev.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.addedby = :nickname")
    List findAllByAddedby(String nickname);
}

