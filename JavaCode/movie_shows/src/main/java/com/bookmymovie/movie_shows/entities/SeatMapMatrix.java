package com.bookmymovie.movie_shows.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat_map_matrix")
public class SeatMapMatrix {
    @Id
    private int id;
    private String row;
    private int col;
    private String status;
    @OneToOne(mappedBy = "seatMapMatrix")
    SeatMap seatMap;
}
