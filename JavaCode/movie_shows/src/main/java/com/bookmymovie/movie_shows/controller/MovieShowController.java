package com.bookmymovie.movie_shows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.movie_shows.dtos.MovieShowsBrowsingResponse;
import com.bookmymovie.movie_shows.service.MovieShowService;

@RestController
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @GetMapping("/movie-shows")
    public ResponseEntity<MovieShowsBrowsingResponse> browseMovieShows(@RequestParam String movie, @RequestParam String city, @RequestParam String date){

        return ResponseEntity.ok(movieShowService.getMovieShows(movie, city, date));
    }
}
