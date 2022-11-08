package com.bookmymovie.movie_shows.entities;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Customer {
    @Id
    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String contact;
    @OneToMany(mappedBy = "customer")
    private List<MovieBooking> bookings;
}
