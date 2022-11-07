package com.bookmymovie.movie_bookings.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "movie")
@IdClass(MovieId.class)
public class Movie {
    private String name;
    private String genre;
    private int duration;
    @OneToMany(mappedBy = "movie")
    private List<Theatre> theatres;
}
