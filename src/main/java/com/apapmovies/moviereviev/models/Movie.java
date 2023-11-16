package com.apapmovies.moviereviev.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructord
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rating")
    private double rating;
    @Column(name = "review")
    private String review;
    @Column(name = "title")
    private String title;
    @Column(name = "addedby")
    private String addedby;
    @Column(name = "date")
    private LocalDate date;


    public Movie(int id, double rating, String review, String title, String addedby) {
        this.id = id;
        this.rating = rating;
        this.review = review;
        this.title = title;
        this.addedby = addedby;
    }
}
