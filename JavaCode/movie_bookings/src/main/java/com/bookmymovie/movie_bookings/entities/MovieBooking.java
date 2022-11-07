package com.bookmymovie.movie_bookings.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class MovieBooking {
    @Id
    private int id;
    @JsonProperty("booking_ref")
    @Column(name = "booking_ref")
    private String bookingRef;
    @ManyToOne
    @JoinColumn( name = "customerid", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn( name = "theatreid", referencedColumnName = "id")
    private Theatre theatre;
    @ManyToOne
    @JoinColumn( name = "movieshowid", referencedColumnName = "id")
    @Column( name = "movie_show")
    private MovieShow movieShow;
    @OneToMany(mappedBy = "booking")
    private List<MovieSubBooking> subBookings;
    private int quantity;
    private LocalDate date;
    private String status;
}
