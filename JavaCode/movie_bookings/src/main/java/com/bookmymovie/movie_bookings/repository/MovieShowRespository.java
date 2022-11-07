package com.bookmymovie.movie_bookings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmymovie.movie_bookings.entities.MovieShow;

@Repository
public interface MovieShowRespository extends CrudRepository<MovieShow, Integer> {


}
