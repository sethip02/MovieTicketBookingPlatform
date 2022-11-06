package com.bookmymovie.movie_shows.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.movie_shows.dtos.MovieShowsBrowsingResponse;
import com.bookmymovie.movie_shows.entities.MovieShow;
import com.bookmymovie.movie_shows.entities.Theatre;
import com.bookmymovie.movie_shows.models.MovieShowTimings;
import com.bookmymovie.movie_shows.repository.MovieShowRespository;
import com.bookmymovie.movie_shows.repository.TheatreRepository;
import com.bookmymovie.movie_shows.service.MovieShowService;
import com.bookmymovie.movie_shows.utils.Constants;

@Service
public class MovieShowServiceImpl implements MovieShowService {

    @Autowired
    private MovieShowRespository movieShowRespository;

    @Autowired
    private TheatreRepository theatreRepository;

    public MovieShowsBrowsingResponse getMovieShows(String movie, String city, String date){
        List<Theatre> theatres = theatreRepository.getAllTheatresForCityAndMovie(city, movie);
        Map<Theatre, List<MovieShow>> theatreToMovieShowsMap = new HashMap<>();

        for( Theatre t : theatres){
            theatreToMovieShowsMap.put(t, movieShowRespository.getAllMovieShowsForParticularDayAndTheatre(LocalDate.parse(date),t));
        }

        MovieShowsBrowsingResponse response = new MovieShowsBrowsingResponse();
        for(Map.Entry e : theatreToMovieShowsMap.entrySet()){
            MovieShowTimings movieShowTimings = new MovieShowTimings();
            movieShowTimings.setTheatre(((Theatre)e.getKey()).getName());
            List<String> showTimings = new ArrayList<>();
            for(MovieShow movieShow: (List<MovieShow>)e.getValue()){
                showTimings.add(movieShow.getTime().format(DateTimeFormatter.ofPattern("hh.mm aa")));
            }
            Collections.sort(showTimings);
            movieShowTimings.setShowTimings(showTimings);

        }
        response.setDate(date);
        response.setStatus(Constants.SUCCESS);
        return response;


    }
}
