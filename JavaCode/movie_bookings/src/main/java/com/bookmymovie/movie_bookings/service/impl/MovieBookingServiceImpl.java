package com.bookmymovie.movie_bookings.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmymovie.movie_bookings.dtos.BookMovieTicketRequest;
import com.bookmymovie.movie_bookings.dtos.BookMovieTicketResponse;
import com.bookmymovie.movie_bookings.entities.Movie;
import com.bookmymovie.movie_bookings.entities.MovieShow;
import com.bookmymovie.movie_bookings.entities.SeatMapMatrix;
import com.bookmymovie.movie_bookings.entities.Theatre;
import com.bookmymovie.movie_bookings.repository.TheatreRepository;
import com.bookmymovie.movie_bookings.service.MovieBookingService;

public class MovieBookingServiceImpl implements MovieBookingService {

    @Autowired
    TheatreRepository theatreRepository;


    @Override
    public BookMovieTicketResponse bookTickets(BookMovieTicketRequest request) throws Exception {
        BookMovieTicketResponse response = new BookMovieTicketResponse();
        List<Theatre> theatres = theatreRepository.findTheatreByName(request.getTheatre());
        List<MovieShow> associatedMovieShows = theatres.get(0).getMovieShows();
        boolean movieShowFound = false;
        MovieShow referencedMovieShow = null;
        for(MovieShow ms : associatedMovieShows){
            if(ms.getTime().equals(LocalTime.parse(request.getShow_timing(), DateTimeFormatter.ofPattern("hh.mm aa")))){
                referencedMovieShow = ms;
                movieShowFound = true;
            }
        }

        if(! movieShowFound){
            throw new Exception("Movie show does not exists");
        }

        List<SeatMapMatrix> seatMatrix = referencedMovieShow.getSeatMap().getSeatMapMatrix();
        //Check if the seats are available
        
        return response;
    }
}
