package com.bookmymovie.movie_bookings.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="seat_map")
@Data
public class SeatMap {
    @Id
    private int id;
    @OneToOne
    @JoinColumn( name = "movieshow_id", referencedColumnName = "id")
    private MovieShow movieShow;
    @OneToMany
    @JoinColumn( name = "seatmap_id", referencedColumnName = "id")
    private List<SeatMapMatrix> seatMapMatrix;


}
