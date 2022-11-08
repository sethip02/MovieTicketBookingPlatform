package com.bookmymovie.movie_bookings.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookMovieTicketRequest {

    private String theatre;
    private String movie;
    private String show_timing;
    @JsonProperty("seat_selection")
    private List<List<String>> seatSelection;
    private String date;
}
