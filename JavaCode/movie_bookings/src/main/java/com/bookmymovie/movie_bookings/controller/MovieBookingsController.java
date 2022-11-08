package com.bookmymovie.movie_bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.movie_bookings.dtos.BookMovieTicketRequest;
import com.bookmymovie.movie_bookings.dtos.BookMovieTicketResponse;
import com.bookmymovie.movie_bookings.service.MovieBookingService;

@RestController
public class MovieBookingsController {


    @Autowired
    MovieBookingService movieBookingsService;

    @PostMapping(value = "/movie-bookings")
    public ResponseEntity<BookMovieTicketResponse> bookMovieTickets(BookMovieTicketRequest bookMovieTicketRequest) throws Exception {
        return ResponseEntity.ok(movieBookingsService.bookTickets(bookMovieTicketRequest));

    }
}
