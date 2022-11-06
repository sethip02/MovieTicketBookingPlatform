package com.bookmymovie.movie_shows.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieShowTimings {

    private String theatre;
    @JsonProperty("show_timings")
    private List<String> showTimings;

}
