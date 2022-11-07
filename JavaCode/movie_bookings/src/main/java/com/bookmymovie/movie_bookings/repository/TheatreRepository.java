package com.bookmymovie.movie_bookings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmymovie.movie_bookings.entities.Theatre;


@Repository
public interface TheatreRepository extends CrudRepository<Theatre, Integer> {
    @Query("Select t from Theatre t where t.name = ?1")
    public List<Theatre> findTheatreByName(String name);
}
