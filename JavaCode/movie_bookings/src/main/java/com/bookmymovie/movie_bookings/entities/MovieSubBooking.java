package com.bookmymovie.movie_bookings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name ="selected_seat_row")
    private String selectedSeatRow;
    @Column( name = "selected_seat_col")
    private int selectedSeatCol;
    @Column( name = "ticket_number")
    private String ticketNumber;
}
