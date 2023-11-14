package com.apapmovies.moviereviev.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    private double rating;
    private String review;
    private String title;

    public Movie(int movie_id, double rating, String review, String title) {
        this.movie_id = movie_id;
        this.rating = rating;
        this.review = review;
        this.title = title;
    }
}
