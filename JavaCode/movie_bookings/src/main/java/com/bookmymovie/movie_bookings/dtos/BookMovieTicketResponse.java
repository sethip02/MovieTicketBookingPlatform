package com.bookmymovie.movie_bookings.dtos;

import java.util.List;

import com.bookmymovie.movie_bookings.exception.APIError;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookMovieTicketResponse {
    @JsonProperty("booking_ref")
    private String bookingRef;
    @JsonProperty("booking_status")
    private String bookingStatus;
    @JsonProperty("booking_data")
    private BookMovieTicketRequest bookingData;
    private String status;
    private List<APIError> errors;

}
