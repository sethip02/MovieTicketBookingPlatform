package com.bookmymovie.movie_shows.dtos;

import java.util.List;

import com.bookmymovie.movie_shows.exception.APIError;
import com.bookmymovie.movie_shows.models.MovieShowTimings;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieShowsBrowsingResponse {
    @JsonProperty("movie_show_data")
    private List<MovieShowTimings> movieShowData;
    private String date;
    private String status;
    private List<APIError> errors;
}
