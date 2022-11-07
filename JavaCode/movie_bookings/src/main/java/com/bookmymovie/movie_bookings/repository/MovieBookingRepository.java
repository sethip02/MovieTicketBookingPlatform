package com.bookmymovie.movie_bookings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmymovie.movie_bookings.entities.MovieBooking;

@Repository
public interface MovieBookingRepository extends CrudRepository<MovieBooking, Integer> {
}
