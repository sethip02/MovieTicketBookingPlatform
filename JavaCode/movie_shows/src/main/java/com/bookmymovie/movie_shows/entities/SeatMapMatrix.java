package com.bookmymovie.movie_shows.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="seat_map_matrix")
@Data
public class SeatMapMatrix {
    @Id
    private int id;
    private String row;
    private int col;
    private String status;
    @ManyToOne
    private SeatMap seatMap;
    @OneToOne(mappedBy = "seatMatrix")
    private MovieSubBooking movieSubBooking;
}
