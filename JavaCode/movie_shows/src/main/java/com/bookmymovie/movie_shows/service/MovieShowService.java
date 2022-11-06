package com.bookmymovie.movie_shows.service;

import com.bookmymovie.movie_shows.dtos.MovieShowsBrowsingResponse;

public interface MovieShowService {
    MovieShowsBrowsingResponse getMovieShows(String movie, String city, String date);
}
