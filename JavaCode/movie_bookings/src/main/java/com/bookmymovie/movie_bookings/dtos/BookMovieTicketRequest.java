package com.bookmymovie.movie_bookings.dtos;

import java.util.List;

import lombok.Data;

@Data
public class BookMovieTicketRequest {

    private String theatre;
    private String movie;
    private String show_timing;
    private List<List<String>> seat_selection;
    private String date;
}
