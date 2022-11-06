package com.bookmymovie.movie_shows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookmymovie.movie_shows.entities.Theatre;

public interface TheatreRepository extends CrudRepository<Theatre, Integer> {
    @Query("SELECT t from Theatre t where t.city = ?1 and t.movie = ?2")
    List<Theatre> getAllTheatresForCityAndMovie(String city, String movie);
}
