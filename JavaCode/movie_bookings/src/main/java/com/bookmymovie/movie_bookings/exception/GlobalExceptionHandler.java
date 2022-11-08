package com.bookmymovie.movie_bookings.exception;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookmymovie.movie_bookings.dtos.BookMovieTicketResponse;
import com.bookmymovie.movie_bookings.utils.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BookMovieTicketResponse> defaultExceptionHandler(Exception e){
        BookMovieTicketResponse errorResponse = new BookMovieTicketResponse();
        errorResponse.setStatus(Constants.API_FAILED_STATUS);
        APIError apiError = new APIError();
        apiError.setErrorCode(Constants.EXCEPTION_ERROR_CODE);
        apiError.setErrorMessage(e.getMessage());
        errorResponse.setErrors(Collections.singletonList(apiError));
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
