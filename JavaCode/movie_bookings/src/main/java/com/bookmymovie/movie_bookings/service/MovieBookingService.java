package com.bookmymovie.movie_bookings.service;

import com.bookmymovie.movie_bookings.dtos.BookMovieTicketRequest;
import com.bookmymovie.movie_bookings.dtos.BookMovieTicketResponse;

public interface MovieBookingService {
    BookMovieTicketResponse bookTickets(BookMovieTicketRequest bookMovieTicketRequest) throws Exception;
}
