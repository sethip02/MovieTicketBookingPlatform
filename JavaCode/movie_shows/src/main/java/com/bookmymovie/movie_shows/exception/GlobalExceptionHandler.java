package com.bookmymovie.movie_shows.exception;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookmymovie.movie_shows.dtos.MovieShowsBrowsingResponse;
import com.bookmymovie.movie_shows.utils.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<MovieShowsBrowsingResponse> defaultExceptionHandler(Exception e){
        MovieShowsBrowsingResponse errorResponse = new MovieShowsBrowsingResponse();
        errorResponse.setStatus(Constants.FAILED);
        APIError apiError = new APIError();
        apiError.setErrorCode(Constants.EXCEPTION_ERROR_CODE);
        apiError.setErrorMessage(e.getMessage());
        errorResponse.setErrors(Collections.singletonList(apiError));
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
