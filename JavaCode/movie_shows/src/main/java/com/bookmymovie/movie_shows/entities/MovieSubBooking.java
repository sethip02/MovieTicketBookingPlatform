package com.bookmymovie.movie_shows.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sub_booking")
@Data
public class MovieSubBooking {
    @Id
    int id;
    @ManyToOne
    @JoinColumn(name = "bookingid", referencedColumnName = "id")
    private MovieBooking booking;
    @OneToOne
    @JoinColumn( name = "seatmapmatrix_id", referencedColumnName = "id")
    private SeatMapMatrix seatMapMatrix;
    @Column( name = "ticket_number")
    private String ticketNumber;
}
