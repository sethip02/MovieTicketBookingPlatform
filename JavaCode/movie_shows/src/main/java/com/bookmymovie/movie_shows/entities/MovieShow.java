package com.bookmymovie.movie_shows.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "movie_show")
@Data
public class MovieShow {
    @Id
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "ThreatreId", referencedColumnName = "id")
    private Theatre theatre;
    @OneToOne(mappedBy = "movieShow")
    private SeatMap seatMap;


}
