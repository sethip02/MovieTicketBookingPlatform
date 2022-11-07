package com.bookmymovie.movie_bookings.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class APIError {
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("error_code")
    private String errorCode;
}
