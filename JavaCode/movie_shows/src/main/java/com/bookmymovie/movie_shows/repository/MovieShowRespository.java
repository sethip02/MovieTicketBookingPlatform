package com.bookmymovie.movie_shows.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmymovie.movie_shows.entities.MovieShow;
import com.bookmymovie.movie_shows.entities.Theatre;

@Repository
public interface MovieShowRespository extends CrudRepository<MovieShow, Integer> {

    @Query("SELECT ms from MovieShow ms where ms.date = ?1 and ms.theatre = ?2")
    List<MovieShow> getAllMovieShowsForParticularDayAndTheatre(LocalDate date, Theatre theatre);

}
