package com.bookmymovie.movie_shows.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat_map")
public class SeatMap {
    @Id
    private int id;
    @OneToOne
    @JoinColumn( name = "movieshow_id", referencedColumnName = "id")
    private MovieShow movieShow;
    @OneToOne
    @JoinColumn( name = "seatmap_id", referencedColumnName = "id")
    private SeatMapMatrix seatMapMatrix;


}
