package com.bookmymovie.movie_bookings.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmymovie.movie_bookings.dtos.BookMovieTicketRequest;
import com.bookmymovie.movie_bookings.dtos.BookMovieTicketResponse;
import com.bookmymovie.movie_bookings.entities.Movie;
import com.bookmymovie.movie_bookings.entities.MovieBooking;
import com.bookmymovie.movie_bookings.entities.MovieShow;
import com.bookmymovie.movie_bookings.entities.MovieSubBooking;
import com.bookmymovie.movie_bookings.entities.SeatMapMatrix;
import com.bookmymovie.movie_bookings.entities.Theatre;
import com.bookmymovie.movie_bookings.repository.MovieBookingRepository;
import com.bookmymovie.movie_bookings.repository.TheatreRepository;
import com.bookmymovie.movie_bookings.service.MovieBookingService;
import com.bookmymovie.movie_bookings.utils.Constants;

public class MovieBookingServiceImpl implements MovieBookingService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    MovieBookingRepository movieBookingRepository;


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
        Set<String> rowSet = new HashSet<>();
        Set<String> colSet = new HashSet<>();
        for(List<String> selectedSeat : request.getSeatSelection()){
            rowSet.add(selectedSeat.get(0));
            colSet.add(selectedSeat.get(1));
        }
        //Check if the seats are available
        long availableSeats = seatMatrix.stream().filter(seat -> seat.getStatus() == Constants.SEAT_AVAILABLE_STATUS).parallel().filter(
            seat -> rowSet.contains(seat.getRow()) && colSet.contains(seat.getCol())
        ).count();

        if (rowSet.size() != availableSeats){
            throw new Exception("Selected seats cannot be booked");
        }
        //Create a booking and subbooking
        MovieBooking movieBooking = new MovieBooking();
        String newBookingRef = UUID.randomUUID().toString();
        movieBooking.setBookingRef(newBookingRef);
        movieBooking.setMovieShow(referencedMovieShow);
        movieBooking.setStatus(Constants.BOOKING_CONFIRMED_STATUS);
        movieBooking.setDate(LocalDate.parse(request.getDate()));
        movieBooking.setTheatre(theatres.get(0));
        movieBooking.setQuantity(request.getSeatSelection().size());

        List<MovieSubBooking> subBookings = new ArrayList<>();

        //Updating the seat status
        seatMatrix.stream().filter(seat -> seat.getStatus() == Constants.SEAT_AVAILABLE_STATUS).parallel().filter(
            seat -> rowSet.contains(seat.getRow()) && colSet.contains(seat.getCol())
        ).forEach( seat -> {
            MovieSubBooking newSubBooking = new MovieSubBooking();
            newSubBooking.setBooking(movieBooking);
            newSubBooking.setTicketNumber(UUID.randomUUID().toString());
            seat.setStatus(Constants.SEAT_BOOKED_STATUS);
            newSubBooking.setSeatMapMatrix(seat);
            subBookings.add(newSubBooking);
        });

        movieBooking.setSubBookings(subBookings);
        movieBookingRepository.save(movieBooking);

        //create final response
        response.setBookingRef(newBookingRef);
        response.setBookingData(request);
        response.setBookingStatus(Constants.BOOKING_CONFIRMED_STATUS);
        response.setStatus(Constants.API_SUCCESS_STATUS);



        return response;
    }
}
